package tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回BST中任意两个不同节点的值之间的最小绝对差值。
 */
public class MinAbsoluteDifferenceInBST_530 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.right = new TreeNode(701);
        root.left.right = new TreeNode(227);
        root.right.right = new TreeNode(911);

        Solution solution = new MinAbsoluteDifferenceInBST_530().new Solution();
        int minimumDifference = solution.getMinimumDifference(root);
        System.out.println(minimumDifference);

    }

    class Solution {

        List<Integer> list = new ArrayList<>();

        /*利用BST中序遍历的性质, 遍历所有元素，集合是升序的
         * 依次比较集合中相邻元素的差值
         * 因为BST的性质，离着越近差值越小*/
        public int getMinimumDifference(TreeNode root) {
            int min = Integer.MAX_VALUE;
            inorder(root);
            /*遍历升序集合，依次比较相邻元素的差值*/
            for (int i = 0; i < list.size() - 1; i++) {
                int temp = list.get(i + 1) - list.get(i);
                min = Math.min(temp, min);
            }

            return min;
        }

        private void inorder(TreeNode root) {
            if (root == null)
                return;
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
