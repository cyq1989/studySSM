package com.yq.proxy;

public class StaticProxyTest {

    public static void main(String[] args) {

        IUserService target = new UserServiceImpl();
        StaticUserServiceProxy proxy = new StaticUserServiceProxy(target);
        proxy.add("陈粒");

    }

}
