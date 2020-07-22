package algorithm.javatest.clonetest;

public class Person implements Cloneable{
    private String name;
    private int age;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //Ç³¿½±´
//        return (Person)super.clone();
        Person person = (Person) super.clone();
        person.address = (Address) address.clone();
        return person;
    }

}
