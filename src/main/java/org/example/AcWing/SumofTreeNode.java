package org.example.AcWing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-10-10 17:34
 **/
public class SumofTreeNode {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int sum) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,sum,ans);
        return res;
    }

    public void dfs(TreeNode root,int sum,List<Integer> ans){
        if(root == null)return;
        ans.add(root.val);
        sum -= root.val;

        if(root.left == null && root.right == null && sum == 0){
            res.add(new ArrayList<>(ans));
        }

        dfs(root.left,sum,ans);
        dfs(root.right,sum,ans);

        ans.remove(ans.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(12);
        root.left.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(1);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> ans = new SumofTreeNode().findPath(root,22);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }


}
