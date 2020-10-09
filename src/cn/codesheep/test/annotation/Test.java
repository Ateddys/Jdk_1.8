package cn.codesheep.test.annotation;

import java.lang.annotation.*;

/**
 * @program: javaSourceLearn
 * @description: 注解温习
 * @author: Mr.Teddy
 * @create: 2020-09-17 11:27
 **/
public class Test{
    @MyAnnotation(name = "teddy")
    public void test(){

    }
}

// 描述注解的使用范围(方法、类）
@Target(value = {ElementType.METHOD, ElementType.TYPE})
// 表示需要在什么级别保存该注释信息，描述注解的生命周期（SOURCE < CLASS < RUNTIME)
@Retention(value = RetentionPolicy.RUNTIME)
// 该注解将被包含在javadoc中  （一般false）
@Documented
// 子类可以继承父类中的该注解  （一般false）
@Inherited
@interface MyAnnotation{
    // 注解参数 ： 参数类型  + 参数名 ();
    String name();
    int age() default 0;
    int id() default -1;    // 如果抄不到
    String[] shoop() default {"夹克衫", "真皮沙发"};
}