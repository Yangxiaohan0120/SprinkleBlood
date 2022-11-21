package org.example.CodingReview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-08-17 10:44
 **/
public class LevelOrderIII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            LinkedList<Integer> list1 = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(list.size() % 2 ==0){
                    list1.addLast(node.val);
                }else list1.addFirst(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(list1);
        }
        return list;
    }
}
