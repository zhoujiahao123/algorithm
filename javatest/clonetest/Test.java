package algorithm.javatest.clonetest;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setAddress(new Address());
        Person person2;
        try {
            //浅拷贝，创建一个新的对象，然后把非引用字段赋值上去，引用字段则也把值赋值（就是给地址）上去。
            person2 = (Person) person1.clone();
            System.out.print(person1 == person2);
            System.out.println(person1.getAddress() == person2.getAddress());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            //浅拷贝，创建一个新的对象，然后把非引用字段赋值上去，引用字段则也把值赋值（就是给地址）上去。
            person2 = (Person) person1.clone();
            System.out.print(person1 == person2);
            System.out.println(person1.getAddress() == person2.getAddress());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
