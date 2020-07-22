package algorithm.javatest.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)//表示该注解可以放在类上
@Retention(RetentionPolicy.RUNTIME)//表示作用范围为运行时
@Documented//可被文档化
@Inherited//可以被继承
@interface AnnotationTest {
    public int id();
    public String description() default "no description";
}
@AnnotationTest(id=1,description = "i am description")
class Utils{
    public static void main(String[] args) {
        AnnotationTest annotationTest = Utils.class.getAnnotation(AnnotationTest.class);
        System.out.print(annotationTest.id()+" " + annotationTest.description());
    }
}
