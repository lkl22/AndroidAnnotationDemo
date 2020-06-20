# AndroidAnnotationDemo
注解学习demo

## 简介
Java 注解（Annotation）又称 Java 标注，是 JDK5.0 引入的一种注释机制。

Java 语言中的类、方法、变量、参数和包等都可以被标注。和 Javadoc 不同，Java 标注可以通过反射获取标注内容。在编译器生成类文件时，标注可以被嵌入到字节码中。Java 虚拟机可以保留标注内容，在运行时可以获取到标注内容 。 当然它也支持自定义 Java 标注。

## [元注解](docs/MetaAnnotation.md)
元注解是用来定义其他注解的注解(在自定义注解的时候，需要使用到元注解来定义我们的注解)。java.lang.annotation提供了四种元注解：@Retention、 @Target、@Inherited、@Documented。

>`元注解是用来修饰注解的注解。在自定义注解的时候我们肯定都是要用到元注解的。因为我们需要定义我们注解的是方法还是变量，注解的存活时间等等。`

元注解|说明
---|---
@Target	|表明我们注解可以出现的地方。是一个ElementType枚举
@Retention	|这个注解的的存活时间
@Document	|表明注解可以被javadoc此类的工具文档化
@Inherited	|是否允许子类继承该注解，默认为false
@Repeatable |这个注解可重复的

## 自定义注解
声明注解步骤：

1. 通过@Retention元注解确定被描述的注解在什么范围内有效。
2. 通过@Target确定我们注解是作用在什么上面的(变量、函数、类等)。
3. 确定我们注解需要的参数。

### [运行时注解](docs/RuntimeAnnotation.md)
运行时注解：在代码运行的过程中通过反射机制找到我们自定义的注解，然后做相应的事情。

>反射：对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性。

自定义编译时注解的步骤：
1. 声明注解
2. 解析注解

### [编译时注解](docs/CompileAnnotation.md)
编译时注解就是在编译的过程中用一个javac注解处理器来扫描到我们自定义的注解，生成我们需要的一些文件(通常是java文件)。

自定义编译时注解的步骤：
1. 声明注解
2. 编写注解处理器 - 生成文件(通常是JAVA文件)

## 参考文献
[Java 注解（Annotation）](https://www.runoob.com/w3cnote/java-annotation.html)

[深入理解Java注解类型(@Annotation)](https://blog.csdn.net/javazejian/article/details/71860633)

[Android 自定义注解(Annotation)](https://blog.csdn.net/wuyuxing24/article/details/81139846)

[jadx反编译工具](https://github.com/BlankLun/jadx)

[javapoet](https://github.com/BlankLun/javapoet)

[AppInit](https://github.com/BlankLun/AppInit)

[WMRouter](https://github.com/BlankLun/WMRouter)