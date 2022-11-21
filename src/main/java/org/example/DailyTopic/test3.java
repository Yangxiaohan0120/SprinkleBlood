package org.example.DailyTopic;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-08-21 10:15
 **/
public class test3 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        long sumEnery = 0;
        for (int i = 0; i < energy.length; i++) {
            sumEnery += energy[i];
        }
        long enplus = sumEnery + 1 - initialEnergy;

        long[] exper = new long[experience.length];
        exper[0] = experience[0];
        long sum = exper[0];
        for (int i = 1; i < exper.length; i++) {
            exper[i] = experience[i] - sum;
            sum += experience[i];
        }
        Arrays.sort(exper);
        long explus = exper[exper.length - 1] + 1 - initialExperience;
        if (explus <= 0) explus = 0;
        return (int) (enplus + explus);
    }

    LinkedList<List<TreeNode>> list = new LinkedList<>();
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        int level = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                TreeNode node = list.get(i).get(j);
                if(node.val == start){
                    level = map.get(node);
                }
            }
        }
        return -1;
    }

    public LinkedList<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root,0);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<TreeNode> list1 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                int level = map.get(node);
                list1.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                    map.put(node.left,level+1);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    map.put(node.right,level+1);
                }
            }
            list.add(list1);
        }
        return null;
    }

    public String largestPalindromic(String num) {
        int[] nums = new int[10];
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            nums[c - '0']++;
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0 && s1.toString().equals("")) {
                continue;
            } else {
                while (nums[i] >= 2) {
                    s1.append(i);
                    s2.append(i);
                    nums[i] -= 2;
                }
            }
        }
        int index = nums.length - 1;
        while (index >= 0) {
            if (nums[index] > 0) {
                s1.append(index);
                break;
            }
            index--;
        }
        String res = s1.toString() + s2.reverse().toString();
        return res;
    }

    public static void main(String[] args) {
//        int initialEnergy = 30, initialExperience = 78;
//        int[] energy = {24, 91, 63, 38, 31, 63, 22, 35, 91, 54, 88, 46, 80, 14, 12, 19, 57, 92};
//        int[] experience = {18, 43, 36, 88, 84, 21, 82, 54, 61, 80, 68, 54, 75, 27, 99, 14, 86, 95};
//        int initialEnergy = 1, initialExperience = 1;
//        int[] energy = {1, 1, 1, 1};
//        int[] experience = {1, 1, 1, 50};
        int initialEnergy = 2, initialExperience = 4;
        int[] energy = {1};
        int[] experience = {3};
        int res = new test3().minNumberOfHours(initialEnergy, initialExperience, energy, experience);
        System.out.println(res);

        String s = "444947137";
        String large = new test3().largestPalindromic(s);
        System.out.println(large);
    }
}
