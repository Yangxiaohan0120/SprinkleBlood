package org.example.AcWing;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-09-01 20:07
 **/

public class cutTree {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return TreeNode类一维数组
     */

    List<TreeNode> list = new ArrayList<>();
    TreeNode node;

    public TreeNode[] balanceSubTree(TreeNode root) {
        // write code here
        node = root;
        recur(node);
        list.add(node);
        TreeNode[] res = new TreeNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void recur(TreeNode root) {
        if (!balanced(root)) {
            if (root.left == null) {
                list.add(root.right);
                root.right = null;
            } else if (root.right == null) {
                list.add(root.left);
                root.left = null;
            } else {
                recur(root.left);
                recur(root.right);
            }
        }
    }

    public boolean balanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(findDepth(root.left) - findDepth(root.right)) > 1) {
            return false;
        } else {
            return true;
        }
    }

    public int findDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(2);
        new cutTree().balanceSubTree(root);
    }

}
