package tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算指定范围的所有节点值之和
 */
public class RangeSumOfBST_938 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        Solution solution = new RangeSumOfBST_938().new Solution();
        System.out.println(solution.rangeSumBST2(root, 7, 15));

    }

    class Solution {
        /**
         * 方法一：
         * 利用BST性质，中序遍历所有节点并保存在list集合中
         * 遍历list集合，求出[low,high]范围所有节点值之和
         */
        List<Integer> list = new ArrayList<>();

        public int rangeSumBST(TreeNode root, int low, int high) {
            inOrder(root);
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= high && list.get(i) >= low) {
                    sum += list.get(i);
                }
            }
            return sum;
        }

        private void inOrder(TreeNode root) {
            if (root == null)
                return;
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }

        /**
         * 方法二：
         * 直接递归先序遍历并判断当前节点值是否在指定范围之内
         * 累加范围之内的所有节点值
         */
        int sum = 0;

        public int rangeSumBST2(TreeNode root, int low, int high) {
            if (root == null)
                return 0;
            if (root.val <= high && root.val >= low)
                sum += root.val;
            rangeSumBST2(root.left, low, high);
            rangeSumBST2(root.right, low, high);
            return sum;
        }
    }
}
