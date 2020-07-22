package algorithm.javatest.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)//��ʾ��ע����Է�������
@Retention(RetentionPolicy.RUNTIME)//��ʾ���÷�ΧΪ����ʱ
@Documented//�ɱ��ĵ���
@Inherited//���Ա��̳�
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
