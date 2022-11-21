package org.example.AcWing;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chris Yang
 * created 2022-10-11 14:23
 **/
public class SerializableBinaryTree {

    // Encodes a tree to a single string.
    String serialize(TreeNode root) {
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + " ");

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root.left != null) {
                sb.append(root.left.val + " ");
                q.add(root.left);
            } else {
                sb.append("null ");
            }

            if (root.right != null) {
                sb.append(root.right.val + " ");
                q.add(root.right);
            } else {
                sb.append("null ");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data) {
        String[] datas = data.split(" ");
        int index = 0;
        TreeNode root = generateStringtoNode(datas[index++]);
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            node.left = generateStringtoNode(datas[index++]);
            node.right = generateStringtoNode(datas[index++]);
            if (node.left != null) {
                q.add(node.left);
            }

            if (node.right != null) {
                q.add(node.right);
            }
        }

        return root;
    }

    TreeNode generateStringtoNode(String val) {
        if (val.equals("null")) {
            return null;
        }

        return new TreeNode(Integer.valueOf(val));
    }

    public static void main(String[] args) {
        String res = "7 null 4 null 3 null null";
        TreeNode root = new SerializableBinaryTree().deserialize(res);
        String out = new SerializableBinaryTree().serialize(root);
        System.out.println(out);
    }
}


