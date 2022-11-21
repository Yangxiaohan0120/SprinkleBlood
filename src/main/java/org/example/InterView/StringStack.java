package org.example.InterView;

import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-10-05 20:13
 **/
public class StringStack {
    public static void main(String[] args) {
        String m = "AAB CCD EDC";
        new StringStack().transString(m);
    }

    public void transString(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                while(!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
                System.out.print(' ');
            }else{
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
