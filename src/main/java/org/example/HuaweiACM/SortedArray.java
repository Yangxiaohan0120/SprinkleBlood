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
        // ������ĸ�б�
        List<Character> letterList = new ArrayList<>();

        // ���ַ���ת�����ַ����飬����ÿһ���ַ������ַ�����ӵ��б���
        for (Character c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letterList.add(c);
            }
        }

        // ����СдӢ����ĸ�����������
        letterList.sort(Comparator.comparingInt(Character::toLowerCase));

        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                result.append(letterList.get(j++));
            } else {
                // ���Ƿ�Ӣ����ĸ��ֱ�����
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
