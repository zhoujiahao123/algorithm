package algorithm.findJob.jvm;

public class DispatcherTest {
    static class Father {
        int money = 1;

        public Father() {
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Father ,I have money :" + money);
        }
    }

    static class Son extends Father{
        int money = 0;

        public Son() {
            money = 1;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Son ,I have money :" + money);
        }
    }

    public static void main(String[] args) {
        Father son = new Son();
        System.out.println(son.money);
    }
}
