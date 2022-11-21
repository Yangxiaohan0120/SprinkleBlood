package org.example.HuaweiACM;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-08-23 20:33
 **/
public class SortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sort(sc.nextLine()));
        sc.close();
    }

    private static String sort(String s) {
        // 定义字母列表
        List<Character> letterList = new ArrayList<>();

        // 将字符串转换成字符数组，遍历每一个字符，是字符则添加到列表中
        for (Character c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letterList.add(c);
            }
        }

        // 按照小写英文字母排序规则排序
        letterList.sort(Comparator.comparingInt(Character::toLowerCase));

        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                result.append(letterList.get(j++));
            } else {
                // 若是非英文字母则直接添加
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
