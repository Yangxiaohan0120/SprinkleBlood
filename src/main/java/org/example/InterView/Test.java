package org.example.InterView;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chris Yang
 * created 2022-08-18 17:52
 **/
public class Test {

    public int lengthOfLongestSubstring (String s) {
        // write code here
        if(s.length() == 0)return 0;
        int i = 0,j = 0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max,j-i);
            }else{
                while(i < j && set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        max = Math.max(max,j-i);
        return max;
    }

    public static void main(String[] args) {
        String s = "cdd";
        System.out.println(new Test().lengthOfLongestSubstring(s));

        Executors executors;

        ThreadPoolExecutor executor;
    }
}
