package algorithm.javatest.upChange;

public class UpChange {
    public void printUpChange(){
        System.out.println("father");
    }

    public static void main(String[] args) {
        UpChangeSon son = new UpChangeSon();
        UpChange father = (UpChange)son;
    }

}
class UpChangeSon extends UpChange{
    public void dosomeThind(){
        System.out.println("son");
    }
}