package org.example.EnterpriseInterview.Bilibili;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-08-11 13:10
 **/
public class ValidCharacter {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                if(map.get(c) == stack.peek()){
                    stack.pop();
                }else return false;
            } else return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "]";
        System.out.println(new ValidCharacter().isValid(s));
    }
}
