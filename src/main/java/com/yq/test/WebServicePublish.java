package com.yq.test;

import javax.xml.ws.Endpoint;

public class WebServicePublish {

    public static void main(String[] args) {

        //定义WebService的发布地址，这个发布地址就是供给外界访问WebService的URL地址，URL地址格式为
        //http://ip:端口号/xxx
        String address = "http://192.168.40.186:7980/WS_Server/Webservice";

        //使用Endpoint类提供的publish方法发布WebService,发布时保证使用端口号没有被其他应用程序占用
        Endpoint.publish(address, new WebServiceIml());
        System.out.println("发布Webservice成功！");


    }

}
