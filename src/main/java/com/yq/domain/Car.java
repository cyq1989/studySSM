package com.yq.domain;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public Car() {
        System.out.println("car Construct......");
    }

    public void init() {
        System.out.println("init car .......");
    }

    public void destroy() {
        System.out.println("destroy car .......");
    }

}
