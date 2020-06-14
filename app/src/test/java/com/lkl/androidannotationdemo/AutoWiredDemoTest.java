package com.lkl.androidannotationdemo;

import com.lkl.androidannotationdemo.runtime.autowired.AutoWiredDemo;

import org.junit.Test;

public class AutoWiredDemoTest {
    @Test
    public void autoWiredDemoTest() {
        AutoWiredDemo demo = new AutoWiredDemo();
        demo.autoWiredTest();
    }
}
