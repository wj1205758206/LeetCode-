package tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 */
public class BinaryTreePostorderTraversal_145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution solution = new BinaryTreePostorderTraversal_145().new Solution();
        List<Integer> list = solution.postorderTraversal(root);
        list.forEach((i) -> {
            System.out.println(i);
        });
    }

    class Solution {
        List<Integer> list = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null)
                return list;

            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);

            return list;
        }
    }
}
