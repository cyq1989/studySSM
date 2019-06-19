package com.yq.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {

    public Dog() {
        System.out.println("dogConstruct.......");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init() {
        System.out.println("dog init.......@PostConstruct");
    }

    //容器销毁之前调用
    @PreDestroy
    public void destory() {
        System.out.println("dog destory......@PreDestroy");
    }

}
