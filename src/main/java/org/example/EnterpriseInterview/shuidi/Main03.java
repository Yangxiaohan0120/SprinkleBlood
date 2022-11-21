package org.example.EnterpriseInterview.shuidi;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-09-15 19:08
 **/
public class Main03 {

    // 大数加法，使用String相加
    public String sum (String numA, String numB) {
        // write code here
        // write code here
        Stack<String> stack = new Stack<>();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        int i = numA.length() - 1;
        int j = numB.length() - 1;
        int c = 0;
        while(i >= 0 && j >=0){
            int sum = map.get(numA.charAt(i)) + map.get(numB.charAt(j)) + c;
            stack.push(String.valueOf (sum % 10));
            c = sum / 10;
            i--;
            j--;
        }
        while(i >= 0){
            int sum = map.get(numA.charAt(i)) + c;
            stack.push(String.valueOf (sum % 10));
            c = sum / 10;
            i--;
        }
        while(j >= 0){
            int sum = map.get(numB.charAt(j)) + c;
            stack.push(String.valueOf (sum % 10));
            c = sum / 10;
            j--;
        }
        if(c != 0){
            stack.push(String.valueOf(c));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }




    public static void main(String[] args) {
        String numA = "1";
        String numB = "99";
        System.out.println(new Main03().sum(numA,numB));
        char c = 'A';
    }
}
