package tree.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 求二叉搜索树中第 K 个小的元素
 */
public class KthSmallestElementBST_230 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(2);

        Solution solution = new Solution();
        int kthSmallest = solution.kthSmallest2(root, 3);
        System.out.println(kthSmallest);

    }

    static class Solution {

        /**
         * 方法一：构造一个辅助函数用来中序遍历节点值，并保存在list列表中，因为二叉搜索树的中序遍历是升序的，从而求得第 K 个小的值
         */
        List<Integer> inOrderVal = new ArrayList<>();

        public int kthSmallest(TreeNode root, int k) {
            inOrder(root);
            return inOrderVal.get(k - 1);

        }

        private void inOrder(TreeNode root) {
            if (root == null)
                return;
            inOrder(root.left);
            inOrderVal.add(root.val);
            inOrder(root.right);
        }

        /**
         * 方法二：可以不构造辅助函数，无需保存中序遍历的结果
         */
        int kth = 0;    //记录中序遍历当前节点是第几个节点
        int result = -1; //保存第 k 个小的节点值

        public int kthSmallest2(TreeNode root, int k) {
            /*基准条件*/
            if (root == null)
                return -1;

            kthSmallest2(root.left, k);

            /*中序遍历，kth先自增，找第 k 个节点，并记录第 k 个节点的值返回*/
            if (++kth == k) {
                result = root.val;
                return result;
            }

            kthSmallest2(root.right, k);

            return result;
        }
    }
}