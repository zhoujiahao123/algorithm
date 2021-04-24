package algorithm.getMoney.money2;

public class H2_1 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1;i<=10;i++){
            if(i%2==0){
                continue;
            }
            sum = sum + i;
        }
        System.out.println("sum = "+sum);
    }
}
