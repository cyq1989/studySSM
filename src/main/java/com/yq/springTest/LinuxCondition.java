package com.yq.springTest;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断当前系统是否是linux系统
 */
public class LinuxCondition implements Condition {
    /**
     *
     * @param conditionContext  判断条件能使用的上下文条件
     * @param annotatedTypeMetadata  注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //能获取档ioc的bean工程
        ConfigurableListableBeanFactory configurableListableBeanFactory = conditionContext.getBeanFactory();
        //类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //获取bean定义的注册类
        BeanDefinitionRegistry beanDefinitionRegistry = conditionContext.getRegistry();

        if (environment.getProperty("os.name").contains("linux")) {
            return true;
        }
        return false;
    }
}
