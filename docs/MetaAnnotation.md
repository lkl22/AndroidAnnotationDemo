# 元注解
## @Target
@Target元注解用来表明我们注解可以出现的地方，参数是一个ElementType类型的数组，所以@Target可以设置注解同时出现在多个地方。比如既可以出现来类的前面也可以出现在变量的前面。

@Target-ElementType类型|说明
---|---
ElementType.TYPE	|描述类、接口(包括注解类型) 或enum声明
ElementType.FIELD	|用于描述域 - 字段、枚举的常量
ElementType.METHOD	|方法
ElementType.PARAMETER	|方法参数(形式参数)
ElementType.CONSTRUCTOR	|构造函数
ElementType.LOCAL_VARIABLE	|局部变量
ElementType.ANNOTATION_TYPE	|注解
ElementType.PACKAGE	|包
ElementType.TYPE_PARAMETER|用来标注类型参数 @since 1.8
ElementType.TYPE_USE|用于标注任意类型(不包括class) Use of a type @since 1.8

TYPE_USE，类型注解用来支持在Java的程序中做强类型检查，配合第三方插件工具（如Checker Framework），可以在编译期检测出runtime error（如UnsupportedOperationException、NullPointerException异常），避免异常延续到运行期才发现，从而提高代码质量，这就是类型注解的主要作用。

请注意，当注解未指定Target值时，则此注解可以用于任何元素之上，多个值使用{}包含并用逗号隔开，如下：
>`@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})`

## @Retention
@Retention用于描述注解的生命周期(即：被描述的注解在什么范围内有效)。参数是RetentionPolicy枚举对象。默认值为CLASS。

@Retention-RetentionPolicy类型|说明|备注
---|---|---
RetentionPolicy.SOURCE	|源码级别，注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃|
RetentionPolicy.CLASS	|类文件级别，注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期|如Java内置注解，@Override、@Deprecated、@SuppressWarnning等
RetentionPolicy.RUNTIME	|运行时级别，注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在，可以反射获取|如SpringMvc中的@Controller、@Autowired、@RequestMapping等


## @Document
@Document表明我们标记的注解可以被javadoc此类的工具文档化。
>`javadoc -d ./docs DocumentDemo.java DocumentA.java DocumentB.java`
## @Inherited
@Inherited表明我们标记的注解是被继承的。比如，如果一个父类使用了@Inherited修饰的注解，则允许子类继承该父类的注解。但这并不是真的继承，只是通过使用@Inherited，可以让子类Class对象使用getAnnotations()获取父类被@Inherited修饰的注解。

## @Repeatable
Repeatable 自然是可重复的意思。@Repeatable 是 Java 1.8 才加进来的，所以算是一个新的特性。

什么样的注解会多次应用呢？通常是注解的值可以同时取多个。
