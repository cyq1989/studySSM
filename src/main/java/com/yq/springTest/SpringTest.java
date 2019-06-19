package com.yq.springTest;

import com.yq.domain.Color;
import com.yq.domain.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        context.getBean("car");

        context.close();

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
