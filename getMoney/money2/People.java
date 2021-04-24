package algorithm.getMoney.money2;
public class People {
    String name;
    String sex;
    int age;
    public People(String name,String sex){
        this.name = name;
        this.sex = sex;
    }
    public People(String name,String sex,int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    public void introduce(){
        System.out.println("大家好,我叫"+name+",我是一个"+sex+"孩,我今年"+age+"岁");
    }
    public static void main(String[] args) {
        People p1 = new People("小华","女",10);
        p1.introduce();
        People p2 = new People("张三","男",16);
        p2.introduce();
    }
}