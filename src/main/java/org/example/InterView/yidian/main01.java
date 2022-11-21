package org.example.InterView.yidian;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-09-24 19:24
 **/
public class main01 {

    List<String> list = new ArrayList<>();
    public int assembleOrnaments (int x, int y, int z) {
        // write code here
//         // x,y 必须配合，最多有几对，x,y中最小值
        int partA = Math.min(x,y);
        // x,y 配对之后剩余的值加上c，能加入几对
        int partB = Math.max(x,y) - partA + z;
        if(partA <= partB){
            // 如果配对的多，那么就直接返回
            return partA;
        }else{
            // 如果配对的少，说明不够，需要拆解partA，进行配对
            while(partA > partB){
                partA --;
                partB ++;
            }
            return partA;
        }
    }

    public String[] findMaxCommon (String stringA, String stringB) {
        // write code here
        Stack<String> stackA = new Stack<>();
        for (int i = 0; i < stringA.length(); i++) {
            for (int j = 0; j < stringB.length(); j++) {

            }
        }
        return new String[1];
    }

    public static void main(String[] args) {
//        int a = 5, b = 4, c = 1;
//        int res = new main01().assembleOrnaments(a,b,c);
//        System.out.println(res);
        String StringA = "A new social, create your hip play show";
        String StringB = "A new social, and create your hip show";
        String[] res = new main01().findMaxCommon(StringA,StringB);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
