package com.yq.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat construct .......");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy.....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesDet ......");
    }
}
