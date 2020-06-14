package com.lkl.androidannotationdemo;

import com.lkl.androidannotationdemo.meta.inherited.InheritedDemo;

import org.junit.Test;

public class InheritedDemoTest {
    @Test
    public void inheritedDemoTest() {
        InheritedDemo.test();

        /*
         * 已使用的@Inherited注解:[@com.lkl.androidannotationdemo.meta.document.DocumentA()]
         * 没有使用的@Inherited注解:[]
         */
    }
}
