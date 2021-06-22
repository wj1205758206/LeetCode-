package tree.medium;

import java.util.Arrays;

/**
 * 构造最大二叉树
 */
public class MaximumBinaryTree_654 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        Solution solution = new Solution();
        TreeNode root = solution.constructMaximumBinaryTree(nums);
        System.out.println(root.left.val);

    }
    static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            /*基准条件
            * 如果数组长度为0，则无需创建节点进行构造，直接返回null*/
            if (nums.length == 0)
                return null;

            /*获取当前数组中的最大值的索引，使用最大值创建出root节点*/
            int maxIndex = max(nums);
            TreeNode root = new TreeNode(nums[maxIndex]);

            /*将当前数组切分为左右两部分，递归构造出左右子树*/
            root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,maxIndex));
            root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxIndex + 1,nums.length));

            /*返回构造出的二叉树的根节点*/
            return root;
        }

        public int max(int[] nums){
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[index] < nums[i])
                    index = i;
            }
            return index;
        }
    }
}
