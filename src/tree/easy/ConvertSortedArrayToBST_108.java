package tree.easy;

import java.util.Arrays;

/**
 * 将已排序的升序数组转换成高度平衡(左右子树高度差绝对值不大于1)的BST
 */
public class ConvertSortedArrayToBST_108 {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Solution solution = new Solution();
        TreeNode root = solution.sortedArrayToBST(nums);
        System.out.println(root.right.left.val);

    }

    static class Solution {
        /**
         * 升序的数组相当于BST的中序遍历，
         * 将数组转换成BST，首先确定数组中间元素，作为root节点，
         * 左部分元素则作为左子树元素集合，右部分元素则作为右子树元素集合
         * 按照这个规律递归划分数组元素
         *
         * @param nums 已排序的数组
         * @return 返回转换为BST的根节点
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            /*基准条件*/
            if (nums == null || nums.length == 0)
                return null;

            /*当前数组的中间元素即为此次递归遍历的root根节点*/
            TreeNode root = new TreeNode(nums[nums.length / 2]);

            /*构造左子树，按照方法的递归定义，传入左部分数组元素，会从左部分数组元素中构造出新的root根节点，作为当前root的左孩子*/
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));

            /*构造右子树，按照方法的递归定义，传入右部分数组元素，会从右部分数组元素中构造出新的root根节点，作为当前root的右孩子*/
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));

            return root;
        }
    }
}
