package org.example.HuaweiACM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-08-23 21:12
 **/
public class BrotherWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] words = str.split(" ");
        int count = 0;
        String bw = words[words.length - 2];
        String sk = words[words.length - 1];
        int k = Integer.parseInt(sk);
        char[] charbw = bw.toCharArray();
        ArrayList<String> list = new ArrayList();
        for(int i = 1 ; i < words.length - 2 ; i ++){
            String word = words[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars);
            if(!word.equals(bw) && word.length()== bw.length() && Arrays.equals(chars,charbw)){
                list.add(word);
                count ++;
            }
        }

        Collections.sort(list);
        if(k > list.size()){
            System.out.println(count);
        }else{
            System.out.println(count);
            System.out.println(list.get(k-1));
        }
    }
}
