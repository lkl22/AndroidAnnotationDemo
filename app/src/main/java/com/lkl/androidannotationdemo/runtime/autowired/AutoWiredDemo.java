package com.lkl.androidannotationdemo.runtime.autowired;

/**
 * AutoWired注解的使用，在autoWiredTest()方法里面调用了AutoWiredProcess.bind(this);来解析注解。这样在运行的时候就会自动去创建UserInfo对象。
 */
public class AutoWiredDemo {
    //自动创建对象，不用我们去new UserInfo()了
    @AutoWired
    public UserInfo mUserInfo;

    public void autoWiredTest() {
        AutoWiredProcess.bind(this);
        System.out.println(mUserInfo.name);
    }
}
