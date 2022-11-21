package org.example.InterView.baidu;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-09-13 18:46
 **/
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        int count = 0;
        while(sc.hasNext()){
            String s = sc.next();
            if(s.equals("for")){
                stack.add(s);
            }else if(s.equals("{") && !stack.isEmpty() && stack.peek().equals("for")){
                stack.add(s);
            }else if(s.equals("}") && !stack.isEmpty() && stack.peek().equals("{")){
                count = Math.max(stack.size()/2 , count);
                stack.pop();
                stack.pop();
            }
        }
        System.out.println(count);
    }
}
