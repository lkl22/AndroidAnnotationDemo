package com.lkl.androidannotationdemo.compile;

import com.lkl.factorycompiler.Factory;

@Factory(id = "Female", type = People.class)
public class Female extends People {

    @Override
    public String getName() {
        return "女生";
    }

    @Override
    public int getAge() {
        return 27;
    }

    @Override
    public int getSex() {
        return 1;
    }
}