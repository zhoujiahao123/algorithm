package algorithm.getMoney;

import java.util.ArrayList;
import java.util.List;

public class mtques {
    String constantfirst = "FirstConstant";
    Integer integer = 20;
    public static void main(String[] args) {
        int integer = 21;
        Integer myInteger = 22;
        String constantfirst = "test";
    }
    void functionone(int param){
        this.integer = param;
        int integer = 23;
        Integer myinteger = 24;
        String constantfirst = "test";
    }
    mtques(String constantfirst){
        this.constantfirst = constantfirst;
        System.out.println(integer);
    }
}
class Veyron{
    String speed;
    Veyron(String speed){
        this.speed = speed;
    }
    void print(){
        System.out.println(speed);
    }
}