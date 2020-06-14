package com.lkl.androidannotationdemo;

import com.lkl.androidannotationdemo.runtime.db.TableCreator;

import org.junit.Test;

public class DbDemoTest {
    @Test
    public void dbDemoTest() {
        try {
            TableCreator.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
