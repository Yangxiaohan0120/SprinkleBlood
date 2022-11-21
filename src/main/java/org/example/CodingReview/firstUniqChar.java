package org.example.CodingReview;

import java.util.HashMap;

/**
 * @author Chris Yang
 * created 2022-08-17 10:32
 **/
public class firstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> map = new HashMap<>();
        char[] cArr = s.toCharArray();
        for(char c : cArr){
        }
        for(char c: cArr){
            if(map.get(c)){
                return c;
            }
        }
        return ' ';
    }
}
