package tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * BST转换为递增的单右子树
 */
public class IncreasingOrderSearchTree_897 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        Solution solution = new IncreasingOrderSearchTree_897().new Solution();
        TreeNode newRoot = solution.increasingBST(root);
        System.out.println(newRoot.val);

    }

    /*利用BST性质，中序遍历所有节点值，并保存在list集合中
     * 遍历list集合循环构造出节点值*/
    class Solution {
        List<Integer> list = new ArrayList<>();

        public TreeNode increasingBST(TreeNode root) {
            inOrder(root);
            TreeNode newRoot = new TreeNode(list.get(0));
            TreeNode temp = newRoot;
            for (int i = 1; i < list.size(); i++) {
                temp.right = new TreeNode(list.get(i));
                temp = temp.right;
            }

            return newRoot;
        }

        private void inOrder(TreeNode root) {
            if (root == null)
                return;
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }
}
