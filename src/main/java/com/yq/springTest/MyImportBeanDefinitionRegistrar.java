package com.yq.springTest;

import com.yq.domain.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        if (beanDefinitionRegistry.containsBeanDefinition("com.yq.domain.Red")) {
            //指定bean的定义信息，比如scop等
            RootBeanDefinition definition = new RootBeanDefinition(RainBow.class);
            //注册bean
            beanDefinitionRegistry.registerBeanDefinition("rainBow", definition);
        }
    }
}
