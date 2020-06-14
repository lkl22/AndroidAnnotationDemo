//@ElementTypeAnnotation
package com.lkl.androidannotationdemo.meta;

import java.util.List;

@ElementTypeAnnotation
public class ElementTypeAnnotationTest {
}

@ElementTypeAnnotation
class TypeParameterClass<@ElementTypeAnnotation T> {
    @ElementTypeAnnotation
    private int c;

    //用于通配符绑定
    List<@ElementTypeAnnotation ? extends String> d;
    List<? extends @ElementTypeAnnotation String> e;

    @ElementTypeAnnotation TypeParameterClass(@ElementTypeAnnotation T b) {

    }

    public <@ElementTypeAnnotation U> @ElementTypeAnnotation T foo(@ElementTypeAnnotation T t)
            throws @ElementTypeAnnotation Exception { //用于指定异常
        @ElementTypeAnnotation
        String b = "b";

        //用于构造函数
        new @ElementTypeAnnotation String("/usr/bin");

        //用于强制转换和instanceof检查,注意这些注解中用于外部工具，它们不会对类型转换或者instanceof的检查行为带来任何影响。
        String path = (@ElementTypeAnnotation String) b;
        if (b instanceof @ElementTypeAnnotation String) {

        }
        return null;
    }
}

@ElementTypeAnnotation
interface Test {
    @ElementTypeAnnotation
    String a = "a";

    @ElementTypeAnnotation
    String get(@ElementTypeAnnotation int a) throws @ElementTypeAnnotation Exception;
}

@ElementTypeAnnotation
enum LanguageEnum {
    @ElementTypeAnnotation
    LANGUAGE("language"),//语言，用于SharedPreferences存储的Key值
    LANGUAGE_zh("zh"),//中文，用于SharedPreferences存储的Value值
    LANGUAGE_en("en"), //英语
    LANGUAGE_es("es"),//西语
    LANGUAGE_fr("fr"),//法语
    LANGUAGE_ar("ar"),//阿语
    LANGUAGE_ru("ru");//俄语

    @ElementTypeAnnotation
    private String language;//自定义属性

    @ElementTypeAnnotation
    /**构造函数，枚举类型只能为私有*/
    LanguageEnum(String language) {
        this.language = language;
    }

    //自定义方法
    @ElementTypeAnnotation
    public String getLanguage() {
        return language;
    }
}