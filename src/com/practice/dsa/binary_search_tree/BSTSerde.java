package com.practice.dsa.binary_search_tree;

import static com.practice.dsa.binary_tree.InorderTraversal.inorderTraversal;

import com.practice.dsa.binary_tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class BSTSerde {

  static public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      StringBuilder sb = new StringBuilder();
      queue.offer(root);
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node == null) {
          sb.append("#,");
          continue;
        }

        sb.append(node.val).append(",");
        queue.offer(node.left);
        queue.offer(node.right);
      }

      return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data.isEmpty() || data.charAt(0) == '#') {
        return null;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      String[] split = data.split(",");
      TreeNode root = new TreeNode(Integer.parseInt(split[0]));
      queue.offer(root);
      for (int i = 1; i < split.length; i++) {
        TreeNode parent = queue.poll();
        if (!split[i].equals("#")) {
          TreeNode left = new TreeNode(Integer.parseInt(split[i]));
          parent.left = left;
          queue.offer(left);
        }

        i++;
        if (!split[i].equals("#")) {
          TreeNode right = new TreeNode(Integer.parseInt(split[i]));
          parent.right = right;
          queue.offer(right);
        }
      }
      return root;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);

    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    //         1
    //       /   \
    //      2     3
    //          /   \
    //         4     5

    var serde = new Codec();
    System.out.println(serde.serialize(root));
    System.out.println(serde.deserialize(serde.serialize(root)));
    System.out.println(inorderTraversal(root));
  }
}
