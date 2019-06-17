package com.yq.test;

public class Singleton {

    private static Singleton singleton = new Singleton();

    //构造方法私有化
    private Singleton() {

    }

    public static Singleton getSingletonInstance() {
        return singleton;
    }




}
