package algorithm.javatest.unSafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnSafe {
    private static  Unsafe unSafe;
    private static  long stateOffset;
    private volatile long state = 0;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unSafe = (Unsafe) field.get(null);
            stateOffset = unSafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestUnSafe test = new TestUnSafe();
        boolean success = unSafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(success);
    }
}
