# 自定义运行时注解

## 声明注解
1. 通过@Retention(RetentionPolicy.RUNTIME)元注解确定我们注解是在运行的时候使用。
2. 通过@Target确定我们注解是作用在什么上面的(变量、函数、类等)。
3. 确定我们注解需要的参数。
## 解析注解
1. 找到类对应的所有属性或者方法(至于是找类的属性还是方法就要看我自定义的注解是定义方法上还是属性上了)。
2. 找到添加了我们注解的属性或者方法。
3. 做我们注解需要自定义的一些操作。
### 1、获取类的属性和方法
通过Class对象我们就可以很容易的获取到当前类里面所有的方法和属性了：

方法|说明
---|---
public String getName();|获取包名加类名
public String getSimpleName();|获取类名
public Constructor<?>[] getConstructors();|返回当前类和父类的public构造方法
public Constructor<?>[] getDeclaredConstructors();|返回当前类所有的构造方法(public、private和protected)不包括父类
public Field[] getFields();|返回当前类所有public的字段，包括父类
public native Field[] getDeclaredFields();|返回当前类所有申明的字段，即包括public、private和protected，不包括父类
public Method[] getMethods();|返回当前类所有public的方法，包括父类
public Method[] getDeclaredMethods();|返回当前类所有的方法，即包括public、private和protected，不包括父类
public Method getEnclosingMethod();|获取局部或匿名内部类在定义时所在的方法
public Package getPackage();|获取当前类的包
public String getPackageName();|获取当前类的包名
public Type getGenericSuperclass();|获取当前类的直接超类的 Type
public Class<?>[] getInterfaces();|返回当前类直接实现的接口.不包含泛型参数信息
public int getModifiers();|返回当前类的修饰符，public,private,protected

类里面每个属性对应一个对象Field，每个方法对应一个对象Method。

### 2、找到添加注解的属性或者方法

每个属性对应Field，每个方法对应Method。而且Field和Method都实现了AnnotatedElement接口。都有AnnotatedElement接口我们就可以很容易的找到添加了我们指定注解的方法或者属性了。

AnnotatedElement接口常用方法如下:

返回值|方法名称|说明
---|---|---
\<T extends Annotation>	T|getAnnotation(Class<T> annotationClass)	|该元素如果存在指定类型的注解，则返回这些注解，否则返回 null。
Annotation[]	|getAnnotations()	|返回此元素上存在的所有注解，包括从父类继承的
boolean	|isAnnotationPresent(Class<? extends Annotation> annotationClass)	|如果指定类型的注解存在于此元素上，则返回 true，否则返回 false。
Annotation[]	|getDeclaredAnnotations()	|返回直接存在于此元素上的所有注解，注意，不包括父类的注解，调用者可以随意修改返回的数组；这不会对其他调用者返回的数组产生任何影响，没有则返回长度为0的数组
\<T extends Annotation> T[] |getAnnotationsByType(Class<T> annotationClass)|返回该元素指定类型的注解
\<T extends Annotation> T[] |getDeclaredAnnotationsByType(Class<T> annotationClass)|返回直接存在该元素上某类型的注解，不包括父类

### 3、做自定义注解需要做的事情
添加了我们注解的属性或者方法已经拿到了，之后要做的就是自定义注解自定义的一些事情了。比如在某些特定条件下自动去执行我们添加注解的方法。



