package com.lkl.androidannotationdemo.meta.inherited;

import com.lkl.androidannotationdemo.meta.document.DocumentA;
import com.lkl.androidannotationdemo.meta.document.DocumentB;

import java.util.Arrays;

@DocumentA
class A{ }

class B extends A{ }

@DocumentB
class C{ }

class D extends C{ }

public class InheritedDemo {
    public static void test(){
        A instanceA=new B();
        System.out.println("已使用的@Inherited注解:"+ Arrays.toString(instanceA.getClass().getAnnotations()));

        C instanceC = new D();

        System.out.println("没有使用的@Inherited注解:"+Arrays.toString(instanceC.getClass().getAnnotations()));
    }
}
