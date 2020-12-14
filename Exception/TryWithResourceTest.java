package algorithm.Exception;

public class TryWithResourceTest {
    public static void main(String[] args) {
        try(TryWithResource tryWithResource = new TryWithResource()){
            System.out.println("do something");
        }catch (Exception e){

        }
    }
}
