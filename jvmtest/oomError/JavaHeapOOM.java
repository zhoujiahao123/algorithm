package algorithm.jvmtest.oomError;

import java.util.ArrayList;
import java.util.List;

public class JavaHeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        String str = new StringBuilder("�����").append("���").toString();
        System.out.println(str == str.intern());

    }
}
