package algorithm.Set.hashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>();
        String str1 = new String("jacob");
        String str2 = new String("jacob");//注意,hash(key)的值会相同因为如果key值一样，那么在同样算法下得出的hash一样。
        set1.add(str1);
        set1.add(str2);
        System.out.println("size : " + set1.size());
        HashSet<Person> set2 = new HashSet<>();
        Person jacob1 = new Person();
        jacob1.setName("jacob");
        Person jacob2 = new Person();
        jacob2.setName("jacob");
        set2.add(jacob1);
        set2.add(jacob2);
        System.out.println("size : " + set2.size());
        HashSet<Person> set3 = new HashSet<>();
        Person jacob3 = new Person();
        jacob3.setName("jacob");
        set3.add(jacob3);
        set3.add(jacob3);
        System.out.println("size : " + set3.size());
        Iterator iterator = set2.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }

    }
}
