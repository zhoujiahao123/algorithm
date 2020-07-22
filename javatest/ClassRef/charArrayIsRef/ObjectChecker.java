package algorithm.javatest.ClassRef.charArrayIsRef;

public class ObjectChecker {
    public static boolean isObject(char[] c) {
        try {
            c.getClass().newInstance();
            return true;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        char c[] = {'a','b'};
        System.out.println(c instanceof  Object);
    }

}
