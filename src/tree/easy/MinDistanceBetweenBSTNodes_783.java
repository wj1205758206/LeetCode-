package tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算BST中任意两个节点值之差的最小值
 */
public class MinDistanceBetweenBSTNodes_783 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution solution = new MinDistanceBetweenBSTNodes_783().new Solution();
        System.out.println(solution.minDiffInBST(root));

    }

    /*利用BST性质进行二叉树的中序遍历，得到升序集合list
     * 遍历list，比较相邻两个元素之差，取最小值*/
    class Solution {
        List<Integer> list = new ArrayList<>();

        public int minDiffInBST(TreeNode root) {
            int min = Integer.MAX_VALUE;
            inOrder(root);
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i + 1) - list.get(i) < min) {
                    min = list.get(i + 1) - list.get(i);
                }
            }
            return min;
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
