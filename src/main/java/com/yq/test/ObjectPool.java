package com.yq.test;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectPool {

    //定义一个对象池，key是对象名，value是实际对象
    private Map<String, Object> objectPool = new HashMap<>();

    private Properties config = new Properties();

    //从指定属性文件中初始化Properties对象
    private void init(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            config.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取文件异常");
        }
    }

    //定义一个创建对象的方法
    private Object createObject(String clazzName) throws Exception{
        //获取class对象
        Class<?> calss = Class.forName(clazzName);
        //使用clazz对应的默认的构造器创建实例
        return calss.newInstance();
    }

    public void initPool() throws Exception{
        for (String name : config.stringPropertyNames()) {
            if (!name.contains("%")) {
                objectPool.put(name, createObject(config.getProperty(name)));
            }
        }
    }

    public void initProperty() throws Exception{
        for (String name : config.stringPropertyNames()) {
            if (name.contains("%")) {
                String[] objAndProp = name.split("%");
                Object target = getObject(objAndProp[0]);
                String mtdName = "set" + objAndProp[1].substring(0, 1).toUpperCase() + objAndProp[1].substring(1);
                Class<?> targetClass = target.getClass();
                Method mtd = targetClass.getMethod(mtdName, String.class);
                mtd.invoke(target, config.getProperty(name));
            }
        }
    }

    public Object getObject(String name) {
        return objectPool.get(name);
    }

    public static void main(String[] args) throws Exception{
        ObjectPool objectPool = new ObjectPool();
        objectPool.init("D:\\softtwo\\allIdeaProject\\ssm\\myssh\\src\\main\\java\\com\\yq\\test\\obj.txt");
        objectPool.initPool();
        objectPool.initProperty();
        System.out.println(objectPool.getObject("a"));
    }


}
