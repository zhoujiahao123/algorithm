package algorithm.DataType.integer;

import java.util.List;

public class IntegerTest {
    public static void main(String[] args) {
        testCatch();
    }
    public static void testCatch(){
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);//false
        int i3 = i1;
        int i4 = i2;
        System.out.println(i3 == i4);//true

    }
    public static void testBoxingAndUnBoxing(){
        Integer i1 = 222;
        int i2 = i1;
    }
}
