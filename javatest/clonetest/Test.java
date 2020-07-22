package algorithm.javatest.clonetest;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setAddress(new Address());
        Person person2;
        try {
            //ǳ����������һ���µĶ���Ȼ��ѷ������ֶθ�ֵ��ȥ�������ֶ���Ҳ��ֵ��ֵ�����Ǹ���ַ����ȥ��
            person2 = (Person) person1.clone();
            System.out.print(person1 == person2);
            System.out.println(person1.getAddress() == person2.getAddress());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            //ǳ����������һ���µĶ���Ȼ��ѷ������ֶθ�ֵ��ȥ�������ֶ���Ҳ��ֵ��ֵ�����Ǹ���ַ����ȥ��
            person2 = (Person) person1.clone();
            System.out.print(person1 == person2);
            System.out.println(person1.getAddress() == person2.getAddress());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
