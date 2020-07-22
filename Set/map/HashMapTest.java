package algorithm.Set.map;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public class HashMapTest {
    public static void main(String[] args) throws Exception{
//        HashMap<String,String> map = new HashMap();
//        map.put("jacob","jacob");
//        map.get("jacob");
//        Random random = new Random();
//        random.nextInt(30);
//        ThreadLocalRandom random1 = ThreadLocalRandom.current();
//        random1.nextInt();

        HashMap m = new HashMap<Integer, String>(1000);
        // 利用反射,获取内部字段 "table"
        Class clsHashMap = null;
        Field t = null;
        try {
            clsHashMap = Class.forName("java.util.HashMap");
            Method method = clsHashMap.getDeclaredMethod("resize");
            method.setAccessible(true);
            method.invoke(m);

            t = clsHashMap.getDeclaredField("table");
            t.setAccessible(true);
            Object[] O = ((Object[]) t.get(m));
            System.out.println(O.length);
            for(int i = 0;i<1000;i++){
                m.put(i,"jacob");
                Object[] O1 = ((Object[]) t.get(m));
                if(O1.length !=1024){
                    System.out.println("i :" + i);
                    break;
                }
            }
            Object[] O1 = ((Object[]) t.get(m));
            System.out.println(O1.length);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
