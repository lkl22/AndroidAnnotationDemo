# 编译时注解
## 声明注解
1. 通过@Retention(RetentionPolicy.CLASS)元注解确定我们注解是在编译的时候使用。
2. 通过@Target确定我们注解是作用在什么上面的(变量、函数、类等)。
3. 确定我们注解需要的参数。
## 编写注解处理器
>注解处理器(Annotation Processor)是javac的一个工具，它用来在编译时扫描和处理注解(Annotation)。一个注解的注解处理器，以Java代码（或者编译过的字节码）作为输入，生成文件(通常是.java文件)作为输出。而且这些生成的Java文件同咱们手动编写的Java源代码一样可以调用。(注意：不能修改已经存在的java文件代码)。

注解处理器所做的工作，就是在代码编译的过程中，找到我们指定的注解。然后让我们增加自己特定的逻辑做出相应的处理(通常是生成JAVA文件)。
### 1、注册注解处理器
* 打包注解处理器的时候需要在 META-INF/services 路径下一个特殊的文件 javax.annotation.processing.Processor 。在javax.annotation.processing.Processor文件里面写上我们自定义注解处理器的全称(包加类的名字)如果有多个注解处理器换行写入就可以。
* @AutoService(Processor.class)我们只需要在我们自定义的注解处理器类前面加上google的这个注解，在打包的时候就会自动生成javax.annotation.processing.Processor文件，写入相应的信息。不需要我们手动去创建。
>implementation 'com.google.auto.service:auto-service:1.0-rc3'

```
@AutoService(Processor.class)
public class CustomProcessor extends AbstractProcessor {
}
```
### 2、自定义注解处理器类
自定义的注解处理器类一定要继承AbstractProcessor，在这个类里面找到我们需要的注解，做出相应的处理。

AbstractProcessor函数|说明
---|---
void init(ProcessingEnvironment processingEnvironment)|每个Annotation Processor必须有一个空的构造函数。编译期间，init()会自动被注解处理工具调用，并传入ProcessingEnvironment参数，通过该参数可以获取到很多有用的工具类（Element，Filer，Messager等）
Set<String> getSupportedAnnotationTypes()|用于指定自定义注解处理器(Annotation Processor)是注册给哪些注解的(Annotation)，注解(Annotation)指定必须是完整的包名+类名
SourceVersion getSupportedSourceVersion()|用于指定你的java版本，一般返回：SourceVersion.latestSupported()
boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment)|Annotation Processor扫描出的结果会存储进roundEnvironment中，可以在这里获取到注解内容，编写你的操作逻辑。注意:process()函数中不能直接进行异常抛出,否则程序会异常崩溃。如果返回 true，则这些注解已声明并且不要求后续 Processor 处理它们；如果返回 false，则这些注解未声明并且可能要求后续 Processor 处理它们。

注解处理器的核心是process()方法(需要重写AbstractProcessor类的该方法)，而process()方法的核心是Element元素。Element 代表程序的元素，在注解处理过程中，编译器会扫描所有的Java源文件，并将源码中的每一个部分都看作特定类型的Element。它可以代表包、类、接口、方法、字段等多种元素种类。

在Java 7以后，你也可以使用注解来代替getSupportedAnnotationTypes()和getSupportedSourceVersion()

```java
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({
        "com.lkl.factorycompiler.Factory"
})
public class FactoryProcessor extends AbstractProcessor {
```

Element子类	|说明
---|---
TypeElement	|类或接口元素
VariableElement	|字段、enum常量、方法或构造方法参数、局部变量或异常参数元素
ExecutableElement	|类或接口的方法、构造方法，或者注解类型元素
PackageElement	|包元素
TypeParameterElement	|类、接口、方法或构造方法元素的泛型参数

TypeElement并不包含类本身的信息。你可以从TypeElement中获取类的名字，但是你获取不到类的信息，例如它的父类。这种信息需要通过TypeMirror获取。你可以通过调用elements.asType()获取元素的TypeMirror。

Element基类方法	|说明
---|---
TypeMirror asType();|返回此元素定义的类型，int,long这些
ElementKind getKind();|返回此元素的种类:包、类、接口、方法、字段
Set<Modifier> getModifiers();|返回此元素的修饰符:public、private、protected
Name getSimpleName();|返回此元素的简单名称(类名)
Element getEnclosingElement();|返回封装此元素的最里层元素。如果此元素的声明在词法上直接封装在另一个元素的声明中，则返回那个封装元素；如果此元素是顶层类型，则返回它的包；如果此元素是一个包，则返回 null；如果此元素是一个泛型参数，则返回 null.
List<? extends Element> getEnclosedElements();|返回此元素直接封装的子元素
List<? extends AnnotationMirror> getAnnotationMirrors();|返回直接存在于此元素上的注解，要获得继承的注解，可使用 getAllAnnotationMirrors
<A extends Annotation> A getAnnotation(Class<A> var1);|返回此元素上存在的指定类型的注解

注解解析器帮助类：

注解解析器帮助类	|说明
---|---
Elements	|一个用来处理Element的工具类
Types	|一个用来处理TypeMirror的工具类
Filer	|用于创建文件(比如创建class文件)
Messager	|用于输出，类似printf函数

这四个帮助类都可以在init()函数里面通过ProcessingEnvironment获取到。
```java
    // 用于创建文件
    protected Filer filer;
    // 用来处理TypeMirror的工具类
    protected Types types;
    protected Elements elements;
    // 用于打印信息
    protected Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filer = processingEnvironment.getFiler();
        types = processingEnvironment.getTypeUtils();
        elements = processingEnvironment.getElementUtils();
        messager = processingEnvironment.getMessager();
    }
```

#### 生成文件
生成文件，通常是生成一个java文件。直接调用帮助类Filer的createSourceFile()函数就可以创建一个java文件。之后就是在这个java文件里面写入我们需要的内容了。为了提高大家的开发效率推荐两个写java源文件的开源库JavaWriter和[JavaPoet](https://github.com/BlankLun/javapoet)。

## [代码调试](./CompileAnnotationDebug.md)

