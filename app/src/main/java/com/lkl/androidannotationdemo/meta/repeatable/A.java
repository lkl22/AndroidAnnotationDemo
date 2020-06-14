package com.lkl.androidannotationdemo.meta.repeatable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Java8前无法这样使用
@FilterPath("/web/update")
@FilterPath("/web/add")
@FilterPath("/web/delete")
public class A {
}


// Java8前如果是想实现类似的功能，我们需要在定义@FilterPath注解时定义一个数组元素接收多个值如下
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface FilterPath1 {
    String[] value();
}

//使用
@FilterPath1({"/update", "/add"})
class A1 {
}
