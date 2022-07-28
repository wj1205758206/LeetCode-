
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int low, int high) {
        if (low > high) return null;

        int maxValIndex = getMaxValIndex(nums, low, high);
        int maxVal = nums[maxValIndex];

        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, low, maxValIndex - 1);
        root.right = build(nums, maxValIndex + 1, high);

        return root;
    }

    public int getMaxValIndex(int[] nums, int low, int high) {
        int index = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
