package org.example.InterView.baidu;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-09-13 18:46
 **/
public class Main0 {
    static HashSet<Character> set = new HashSet<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if(s.length() < 5)System.out.println(0);
        char[] arr = s.toCharArray();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        for(int i = 0; i < s.length() - 5; i ++){
            if(isO(arr[i+1],arr[i+2],arr[i+4]) && isN(arr[i],arr[i+3])){
                count ++;
            }
        }
        System.out.println(count);
    }

    public static boolean isO(char a,char b,char c){
        if(a != b && b != c){
            if(set.contains(a) && set.contains(b) && set.contains(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean isN(char a, char b){
        if(a != b){
            if(!set.contains(a) && !set.contains(b)){
                return true;
            }
        }
        return false;
    }
}
