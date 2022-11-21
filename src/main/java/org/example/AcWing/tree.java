package org.example.AcWing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-09-01 19:37
 **/

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}


public class tree {
    public int maxValue(TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    list.add(0);
                } else {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        int n = list.size();


        int k = 0;
        int m = (int) (Math.log(n + 1) / Math.log(2)) + 1;
        n = (int) Math.pow(2, m);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < list.size()) {
                arr[i] = list.get(i);
            } else {
                arr[i] = 0;
            }
        }
        int[] res = new int[m];
        int[] start = new int[m];
        int[] end = new int[m];
        for (int i = 0; i < m; i++) {
            start[i] = (int) (Math.pow(2, i) - 1);
            end[i] = (int) (Math.pow(2, i + 1) - 1);
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = start[i]; j < end[i]; j++) {
                sum += arr[j];
            }
            res[i] = sum;
        }

        List<Integer> all = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            all.add(res[i]);
            for (int j = start[i]; j < end[i]; j++) {
                if (2 * j + 1 < n) {
                    all.add(res[i] - arr[j] + arr[2 * j + 1]);
                }
                if (2 * j + 2 < n) {
                    all.add(res[i] - arr[j] + arr[2 * j + 2]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < all.size(); i++) {
            max = Math.max(max, all.get(i));
        }
        return max;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(8);
        System.out.println(new tree().maxValue(root));
    }
}
