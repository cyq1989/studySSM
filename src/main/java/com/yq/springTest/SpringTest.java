package com.yq.springTest;

import com.yq.domain.Color;
import com.yq.domain.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;
import java.util.Map;

public class SpringTest {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        /**
         * 在创建Spring容器的时候去指定环境（比如测试、正式环境），这个是根据配置文件中的bean上的@Profile注解
         * 1、创建一个ApplicatiionContext
         * 2、设置需要激活的环境
         * 3、注册主配置类
         * 4、启动刷新容器
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test");
        context.register(AppConfiguration.class);
        context.refresh();

        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("要打印的内容：" + name);
        }



//        Color color = (Color) context.getBean("color");
//
//        System.out.println("要答应的部分》》》" + color);

//        context.close();

//        FactoryBean factoryBean1 = (FactoryBean)context.getBean("colorFactoryBean");
//        FactoryBean factoryBean2 = (FactoryBean)context.getBean("colorFactoryBean");
//        System.out.println(factoryBean1 == factoryBean2);

//        String[] definationBeanNames1 = context.getBeanDefinitionNames();
//
//        for (String name : definationBeanNames1) {
//            System.out.println(name);
//        }

//        String[] definationBeanNames = context.getBeanNamesForType(Color.class);
//        for (String name : definationBeanNames) {
//            System.out.println(name);
//        }

//        Map<String, Person> map = context.getBeansOfType(Person.class);
//        System.out.println(map);
//        System.out.println(context.getBean("userService"));
    }

}
