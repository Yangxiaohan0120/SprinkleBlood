package org.example.DailyTopic;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Chris Yang
 * created 2022-08-17 09:44
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class DeepestLeaf {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<List<Integer>> list = new LinkedList<>();
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list1.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(list1);
        }
        List<Integer> list1 = list.get(list.size() -1);
        int sum = 0;
        for(int i : list1){
            sum += i;
        }
        return sum;
    }

    int max = -1;
    int sum = 0;

    public int deepestLeavesSum1(TreeNode root){
        dfs(root,0);
        return sum;
    }

    public void dfs(TreeNode node,int l){
        if(node == null)return;
        if(max < l) {
            max = l;
            sum = node.val;
        }else if(max == l){
            sum += node.val;
        }
        dfs(node.left,l+1);
        dfs(node.right,l+1);
    }

    public static void main(String[] args) {
        // root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        System.out.println(new DeepestLeaf().deepestLeavesSum(root));
    }
}
