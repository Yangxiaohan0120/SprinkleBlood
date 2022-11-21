package org.example;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Chris Yang
 * created ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 **/
public class Main {
    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[j] <= queries[i]) {
                    ans[i] = j + 1;
                    break;
                }
            }
        }
        return ans;
    }

    public static String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                st.pop();
            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int t = st.size();
        for (int i = 0; i < t; i++) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();

    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k];
        int[] a = new int[k];
        int[] b = new int[k];
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        stackA.push(rowConditions[0][0]);
        stackA.push(rowConditions[0][1]);
        for (int i = 1; i < k; i++) {
            if(stackA.isEmpty()){

            }
        }

        for (int i = 0; i < k; i++) {
            a[colConditions[i][1]] += a[colConditions[i][0]] + 1;
        }

        return new int[0][0];
    }


    public static int garbageCollection(String[] garbage, int[] travel) {
        int[] res = new int[travel.length];
        res[0] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            res[i] = res[i - 1] + travel[i];
        }
        int m = 0;
        int p = 0;
        int g = 0;
        int count = 0;
        for (int i = 0; i < garbage.length; i++) {
            int a = contains(garbage[i], 'M');
            int b = contains(garbage[i], 'G');
            int c = contains(garbage[i], 'P');
            count += a + b + c;
            if (a != 0) {
                if (i == 0) {
                    count += 0;
                } else if (m == 0) {
                    count += res[i - 1];
                } else {
                    count += res[i - 1] - res[m - 1];
                }
                m = i;
            }
            if (b != 0) {
                if (i == 0) {
                    count += 0;
                } else if (g == 0) {
                    count += res[i - 1];
                } else {
                    count += res[i - 1] - res[g - 1];
                }
                g = i;
            }
            if (c != 0) {
                if (i == 0) {
                    count += 0;
                } else if (p == 0) {
                    count += res[i - 1];
                } else {
                    count += res[i - 1] - res[p - 1];
                }
                p = i;
            }
        }
        return count;
    }

    public static int contains(String s, Character k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] nums = {4,5,2,1};
//        int[] q = {3,10,21};
//        int[] ans = Main.answerQueries(nums,q);
//        for (int i = 0; i < ans.length; i++) {
//            System.out.println(ans[i]);
//        }
//        System.out.println("Hello world!");

        String[] g = {"G", "P", "GP", "GG"};
        int[] t = {2, 4, 3};
        System.out.println(Main.garbageCollection(g, t));

        String s = "leet**cod*e";
        System.out.println(Main.removeStars(s));
    }
}