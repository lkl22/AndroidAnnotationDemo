package com.lkl.androidannotationdemo.meta;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@interface RetentionPolicyAnnotation1{

}

@Retention(RetentionPolicy.CLASS)
@interface RetentionPolicyAnnotation2{

}

@Retention(RetentionPolicy.RUNTIME)
@interface RetentionPolicyAnnotation3{

}

@interface RetentionPolicyAnnotation{

}

@RetentionPolicyAnnotation
public class RetentionPolicyAnnotationTest {
    @RetentionPolicyAnnotation
    int filed;

    @RetentionPolicyAnnotation
    public RetentionPolicyAnnotationTest(@RetentionPolicyAnnotation int a) {
        @RetentionPolicyAnnotation
        int c = a;

        filed = a;
    }

    @RetentionPolicyAnnotation
    int add(@RetentionPolicyAnnotation int b) {
        return filed + b;
    }
}


@RetentionPolicyAnnotation1
class RetentionPolicyAnnotationTest1 {
    @RetentionPolicyAnnotation1
    int filed;

    @RetentionPolicyAnnotation1
    RetentionPolicyAnnotationTest1(@RetentionPolicyAnnotation1 int a) {
        @RetentionPolicyAnnotation1
        int c = a;

        filed = a;
    }

    @RetentionPolicyAnnotation1
    int add(@RetentionPolicyAnnotation1 int b) {
        return filed + b;
    }
}

@RetentionPolicyAnnotation2
class RetentionPolicyAnnotationTest2 {
    @RetentionPolicyAnnotation2
    int filed;

    @RetentionPolicyAnnotation2
    RetentionPolicyAnnotationTest2(@RetentionPolicyAnnotation2 int a) {
        @RetentionPolicyAnnotation2
        int c = a;

        filed = a;
    }

    @RetentionPolicyAnnotation2
    int add(@RetentionPolicyAnnotation2 int b) {
        return filed + b;
    }
}

@RetentionPolicyAnnotation3
class RetentionPolicyAnnotationTest3 {
    @RetentionPolicyAnnotation3
    int filed;

    @RetentionPolicyAnnotation3
    RetentionPolicyAnnotationTest3(@RetentionPolicyAnnotation3 int a) {
        @RetentionPolicyAnnotation3
        int c = a;

        filed = a;
    }

    @RetentionPolicyAnnotation3
    int add(@RetentionPolicyAnnotation3 int b) {
        return filed + b;
    }
}