package com.yq.springTest;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param annotationMetadata ：当前标注@Import注解类的所有注解
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {
//                "com.yq.domain.Color",
                "com.yq.domain.Red"
        };
    }
}
