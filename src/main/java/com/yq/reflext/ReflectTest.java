package com.yq.reflext;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectTest {

    public static void test() throws Exception{

//        Class personClazz = Class.forName("com.yq.reflext.Person");
//        Person person = (Person)personClazz.newInstance();
//        Method method = personClazz.getDeclaredMethod("haha", null);
//        method.setAccessible(true);
//        method.invoke(person, null);
//        Method[] methods = personClazz.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

        ArrayList list = new ArrayList();
        list.add(1);
        list.add("xx");
        System.out.println(list);


    }


    public static void main(String[] args) throws Exception{

        test();


    }

}
