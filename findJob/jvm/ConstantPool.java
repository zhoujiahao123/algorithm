package algorithm.findJob.jvm;

public class ConstantPool {
    public static void main(String []args) {
        String str1 = "abc";
        String str2 = new String("def");
        String str3 = "abc";
        String str4 = str2.intern();
        String str5 = "def";
        System.out.println(str1 == str3);
        System.out.println(str2 == str4);
        System.out.println(str4 == str5);
    }
}
