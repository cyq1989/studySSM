package com.yq.springTest;

import com.yq.domain.GeMan;
import com.yq.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//表面这个是个配置类
@Configuration
//conditional直接加到类上，表示只有满足当前条件是改配置类中定义的bean才会被加载
@Conditional({WindowsCondition.class})
//可同时添加多个扫描规则
//Filter指定条件过滤  excludeFilters排除那些bean的注册； includeFilters只包含哪些bean的注入
@ComponentScans(value = {
        @ComponentScan(value = "com.yq", includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class, Repository.class})
        }, useDefaultFilters = false)
})
//@Import有三种用法：
// 1、直接@Import(xxx.class)
// 2、写一个实现ImportSelector的类如MyImportSelector
// 3、写一个实现ImportBeanDefinitionRegistrar的类，来手动注册bean到ioc容器的
@Import({GeMan.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//用@ImportResource注解可以导入系统中的配置文件，达到加载配置文件中配置的bean的目的
@ImportResource("classpath:applicationContext-spring.xml")
public class AppConfiguration {

    /**
     * @Conditional :根据条件注册bean
     * 如果系统是windows在系统中放“bill”
     */
    @Bean("bill")
    @Conditional({WindowsCondition.class})
    public Person person1() {
        return new Person("Bill Gates", 62);
    }

    /**
     * @Conditional :根据条件注册bean
     * 如果是linux则注册“linus”
     */
    @Bean("linus")
    @Conditional({LinuxCondition.class})
    public Person person2() {
        return new Person("linus", 48);
    }

    /**
     * 注册factorybean
     * @return
     */
    @Bean("colorFactoryBean")
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}
