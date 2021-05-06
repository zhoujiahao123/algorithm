package algorithm.getMoney.money5;

public class Employee extends Person{
    private double salary;
    private int hiredYear;
    private String id;
    public Employee(String name,double salary,int hiredYear,String id){
        this.setName(name);
        this.salary =salary;
        this.hiredYear = hiredYear;
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getHiredYear() {
        return hiredYear;
    }

    public void setHiredYear(int hiredYear) {
        this.hiredYear = hiredYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employee){
            Employee employee = (Employee) obj;
            if(hasSameName(employee) && this.hiredYear == employee.getHiredYear() && this.salary == employee.getSalary() && this.id.equalsIgnoreCase(employee.getId())){
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("jacob",1888.88,2,"boss");
        Employee employee2 = new Employee("jacob",1888.88,3,"worker");
        Employee employee3 = new Employee("jacob",1888.88,2,"boss");
        System.out.println("Employee 1 name£º"+employee1.getName());
        System.out.println("Employee 1 salary£º"+employee1.getSalary());
        System.out.println("How long has employee 1 been in the shift:"+employee1.getHiredYear());
        System.out.println("Employee 1 type£º"+employee1.getId());
        System.out.println();
        System.out.println("Employee 2 name£º"+employee2.getName());
        System.out.println("Employee 2 salary£º"+employee2.getSalary());
        System.out.println("How long has employee 2 been in the shift:"+employee2.getHiredYear());
        System.out.println("Type of employee 2£º"+employee2.getId());
        System.out.println();
        System.out.println("Employee 3 name£º"+employee3.getName());
        System.out.println("Employee 3 salary£º"+employee3.getSalary());
        System.out.println("How long has employee 3 been in the shift£º"+employee3.getHiredYear());
        System.out.println("types of employees 3£º"+employee3.getId());
        System.out.println();
        System.out.println("Whether employee 1 and employee 2 are the same employee£º"+employee1.equals(employee2));
        System.out.println("Whether employee 1 and employee 3 are the same employee£º"+employee1.equals(employee3));
        System.out.println("Whether employee 2 and employee 3 are the same employee£º"+employee2.equals(employee3));
    }
}
class Person{
    private String name;
    public Person(){
        name = "No name yet";
    }
    public Person(String initialName){
        name = initialName;
    }
    public void setName(String newName){
        name = newName;
    }

    public String getName() {
        return name;
    }
    public void writeOutput(){
        System.out.println("Name:"+name);
    }
    public boolean hasSameName(Person otherPerson){
        return this.name.equalsIgnoreCase(otherPerson.name);
    }
}