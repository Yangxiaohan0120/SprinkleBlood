package org.example.Leetcode;

import java.util.HashMap;

/**
 * @author Chris Yang
 * created 2022-09-04 10:29
 **/
public class Main01 {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character,Integer> first = new HashMap<>();
        HashMap<Character,Integer> second = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(first.containsKey(c)){
                second.put(c,i);
            }else{
                first.put(c,i);
            }
        }

        for(Character c : first.keySet()){
            int num = second.get(c) - first.get(c) - 1;
            if(distance[c - 'a'] != num){
                return false;
            }
        }
        return true;
    }
}
