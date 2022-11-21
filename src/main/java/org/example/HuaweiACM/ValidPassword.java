package org.example.HuaweiACM;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-23 19:35
 **/
public class ValidPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String password = sc.nextLine();
            char[] chars = password.toCharArray();
            int a = 0, b = 0 , c = 0 , d = 0;
            boolean err = true;
            if(chars.length > 8){
                for(int i = 0;i < chars.length ; i ++){
                    char t = chars[i];
                    if(t <= 'z' && t >= 'a'){
                        a = 1;
                    }else if(t <= 'Z' && t >= 'A'){
                        b = 1;
                    }else if(t <= '9' && t >= '0'){
                        c = 1;
                    }else if(t == ' ' && t == '\n'){
                        err = false;
                        break;
                    }else {
                        d = 1;
                    }
                }
                if(err){
                    if((a + b + c + d) >= 3){
                        if(isRepeat(password)){
                            System.out.println("OK");
                        }else{
                            System.out.println("NG");
                        }
                    }else{
                        System.out.println("NG");
                    }
                }else{
                    System.out.println("NG");
                }
            }else{
                System.out.println("NG");
            }
        }


    }

    private static boolean isRepeat(String s){
        for(int i = 3; i < s.length(); i ++){
            if(s.substring(i).contains(s.substring(i-3,i))){
                return false;
            }
        }
        return true;
    }
}
