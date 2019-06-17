package com.yq.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {

        IUserService target = new UserServiceImpl();
        DynamicProxy hander = new DynamicProxy(target);

        /**
         * 第一个参数：代理类的加载器
         * 第二个参数：代理类需要实现的接口（我们传入被代理类实现的接口，这样生成的代理类和被代理类实现相同的接口）
         * 第三个参数是invacation hander 用来处理方法的调用，这里我们传入自己实现的hander
         */
        IUserService proxyObject = (IUserService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), hander);

        proxyObject.add("陈粒");

    }

}
