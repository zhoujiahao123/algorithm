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
        System.out.println("��Һ�,�ҽ�"+name+",����һ��"+sex+"��,�ҽ���"+age+"��");
    }
    public static void main(String[] args) {
        People p1 = new People("С��","Ů",10);
        p1.introduce();
        People p2 = new People("����","��",16);
        p2.introduce();
    }
}