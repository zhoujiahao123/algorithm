package algorithm.getMoney;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Money1 {
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        int count = 0;
        while (true){
            count++;
            String message; //the original string
            String capstr;    //the capital version
            String codedstr="";
            char delimeter; //the delimiter users wish to use
            char space=' ';//
            int digit;      //the amount users wish to shift by
            boolean punc;   //whether or not the user wish to include the original punctuation
            System.out.print("This program will encode messages! :) \n ");
            //Set up the output and input
            System.out.print("Please enter a string to be encoded: ");
            message=input.nextLine();
            System.out.print("Please enter the delimiter you wish to use: ");
            delimeter=input.next().charAt(0);
            System.out.print("Please enter the amount you wish to shift by: ");
            digit=input.nextInt();
            System.out.print("include punctuation? ");
            punc = input.nextBoolean();
            capstr = message.toUpperCase();
            String newstr=capstr.replace(space,delimeter);
            for(int x = 0;x<newstr.length();++x){
                //1：只需要移动字母
                char c =newstr.charAt(x);
                if(c >= 'A' && c<='Z'){
                    //移动的时候注意：是在26个字母中移动，而非全部的ascii码
                    //首先，判断当前字符c是26个字母中的第几个
                    int pos = c-'A';
                    //移动digit位
                    pos += digit;
                    //注意，这里digit可能大于26，因此需要取余
                    pos = pos%26;
                    //定位当前字母
                    c = (char) (pos+'A');
                    codedstr += c;
                }else if(c == '.' || c== ','|| c == '!'|| c=='?'||c==':'||c==';'){
                    if(punc){
                        codedstr += c;
                    }
                }else{
                    codedstr += c;
                }
            }
            System.out.println("the coded message: "+codedstr);
            System.out.print("another?");
            String over = input.next();
            input.nextLine();
            if(!(over.equals("y") || over.equals("Y"))) break;
        }
        System.out.print(count+" string(s) encoded");
    }

}
