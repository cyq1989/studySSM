package com.yq.springTest;

import com.alibaba.druid.pool.DruidDataSource;
import com.yq.domain.Car;
import com.yq.domain.Cat;
import com.yq.domain.Color;
import com.yq.domain.Dog;
import com.yq.domain.GeMan;
import com.yq.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

//表面这个是个配置类
@Configuration

//conditional直接加到类上，表示只有满足当前条件是改配置类中定义的bean才会被加载
@Conditional({WindowsCondition.class})

//可同时添加多个扫描规则
//Filter指定条件过滤  excludeFilters排除那些bean的注册； includeFilters只包含哪些bean的注入
@ComponentScans(value = {
        @ComponentScan(value = "com.yq", includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class, Repository.class, Component.class})
        }, useDefaultFilters = false)
})

//@Import有三种用法：
// 1、直接@Import(xxx.class)
// 2、写一个实现ImportSelector的类如MyImportSelector
// 3、写一个实现ImportBeanDefinitionRegistrar的类，来手动注册bean到ioc容器的
@Import({GeMan.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})

//用@ImportResource注解可以导入系统中的配置文件，达到加载配置文件中配置的bean的目的
@ImportResource("classpath:applicationContext-spring.xml")

//bean的创建：
//   单实例的bean是在容器创建的时候创建，如果是懒加载的bean是在第一次调用的时候创建
//   多实例的bean是在第一调用的时候创建，创建之后交给外部程序管理，spring容器就不管了，如果还需要用该对象的实例，spring容器将再创建一次
//bean的生命周期：bean的创建，初始化，销毁的过程，交由spring容器进行管理
//可以自定初始化和销毁方法，容器会调用我们自定义的初始化和销毁方法
//初始化：
//    是在对象创建完成，并初赋值好之后调用
//销毁：
//    容器关闭的时候
//1、xml配置：指定init-method  和 destroy-method方法
//2、注解方式：@Bean(initMethod = "init", destroyMethod = "destroy")  参考Car
//3、通过让bean实现InitializingBean(定义初始化逻辑)，DisposableBean(定义销毁逻辑)  参考Cat
//

//@Autowired 用于对象的注入：1、标注在属性上；2、标注在构造方法上；3、标注在set方法或者其他普通方法上
        //不管标注在哪，都是从spring容器中获取组件的值
        //注：如果是标注在构造器上，如果该bean只有一个有参构造器，@Autowired注解可以省略
        //注：@Bean标注的方法创建对象时，方法参数的值默认从容器中获取

//xxxAware：功能使用xxxProcessor: ApplicationContextAware ==> ApplicationContextAwareProcessor

@PropertySource("classpath:jdbc.properties")
public class AppConfiguration implements EmbeddedValueResolverAware {

    private StringValueResolver stringValueResolver;

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
     * 指定bean的初始化和销毁方法
     * @return
     */
//    @Bean(initMethod = "init", destroyMethod = "destroy")
//    public Car car() {
//        return new Car();
//    }

    @Bean
    public Cat cat() {
        return new Cat();
    }

    @Bean
    public Color color(Car car) {
        return new Color(car);
    }


    /**
     * 注册factorybean
     * @return
     */
//    @Bean("colorFactoryBean")
//    public ColorFactoryBean colorFactoryBean() {
//        return new ColorFactoryBean();
//    }

    /**
     * 配置数据源
     *
     * @Profile()用于环境的切换，比如测试环境用测试环境的数据源，正式环境用正式环境的数据源
     *
     * 增加一个运行参数：-Dspring.profiles.active=dev
     *
     * @return
     */
    @Profile("test")
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(stringValueResolver.resolveStringValue("${jdbc_driverClassName}"));
        dataSource.setUrl(stringValueResolver.resolveStringValue("${jdbc_url}"));
        dataSource.setUsername(stringValueResolver.resolveStringValue("${jdbc_username}"));
        dataSource.setPassword(stringValueResolver.resolveStringValue("${jdbc_password}"));
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver = stringValueResolver;
    }
}
