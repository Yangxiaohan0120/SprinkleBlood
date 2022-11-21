package org.example.AcWing;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-08-31 09:48
 **/
public class Expression {
    static Stack<Integer> num = new Stack<>();
    static Stack<Character> op = new Stack<>();
    static int x, a, b, j;
    static char c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (Character.isDigit(c)) {
                x = 0;
                j = i;
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    x = x * 10 + str.charAt(j++) - '0';
                }
                i = j - 1;
                num.push(x);
            } else if (c == '(') op.push(c);
            else if (c == ')') {
                while (op.peek() != '(') calculate();
                op.pop();
            } else {
                while (!op.isEmpty() && op.peek() != '(' && map.get(op.peek()) >= map.get(c)) {
                    calculate();
                }
                op.push(c);
            }

        }
        while (!op.isEmpty()) calculate();
        System.out.println(num.peek());
    }

    public static void calculate() {
        b = num.pop();
        a = num.pop();
        c = op.pop();
        x = 0;
        if (c == '+') {
            x = a + b;
        } else if (c == '-') {
            x = a - b;
        } else if (c == '*') {
            x = a * b;
        } else if (c == '/') {
            x = a / b;
        }
        num.push(x);
    }
}
