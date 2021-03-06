package com.lkl.androidannotationdemo.runtime.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解Integer类型的字段
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
    // 该字段对应数据库表列名
    String name() default "";

    // 嵌套注解，default @Constraints要求Constraints里的filed都必须有default值
    Constraints constraint() default @Constraints;
}
