package algorithm.getMoney;

import java.util.ArrayList;
import java.util.List;

public class mtques {
    String constantfirst = "FirstConstant";
    Integer integer = 20;
    public static void main(String[] args) {
        new mtques().functionone();
    }
    public void functionone(){
        int i , s =0;
        for(int k = 0;k<5;++k){
            i = 1;
            while(i<k){
                do {
                    i++;
                    s++;

                }while (i<k);
            }
        }
        System.out.println(s);
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