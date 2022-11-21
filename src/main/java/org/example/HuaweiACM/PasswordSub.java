package org.example.HuaweiACM;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-23 21:39
 **/
public class PasswordSub {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solve(s));
    }

    public static int solve(String s){
        int count = 0;
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        sb.append("#");
        for(int i = 0 ; i < c.length ; i ++){
            sb.append(c[i]);
            sb.append("#");
        }

        int[] rad = new int[sb.length()];
        char[] cl = sb.toString().toCharArray();
        int max = 0;
        int id = 0;
        for(int i = 1; i < cl.length ; i ++){
            if(max > i){
                rad[i] = Math.min(rad[2*id - 1],max-i);
            }else{
                rad[i] = 1;
            }
            while(i - rad[i] >= 0 && i+rad[i] < cl.length && cl[(i-rad[i])] == cl[i + rad[i]]){
                rad[i] ++;
            }
            if(i + rad[i] > max){
                max = i+rad[i];
                id = i;
            }
            count = Math.max(count,rad[i] - 1);
        }
        return count;
    }
}
