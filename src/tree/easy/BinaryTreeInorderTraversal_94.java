package tree.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class BinaryTreeInorderTraversal_94 {
    public static void main(String[] args) {

    }

    static class Solution {
        List<Integer> list = new LinkedList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null)
                return list;
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);

            return list;
        }
    }
}
