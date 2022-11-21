package org.example.EnterpriseInterview.pdd;

import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-08-11 21:51
 **/
public class InvalidCharacter {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = s.length();
        int count = 0;
        int max = 0;
        stack.push(-1);
        while (i < n) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i - stack.peek());
                }
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(new InvalidCharacter().longestValidParentheses(s));
    }
}
