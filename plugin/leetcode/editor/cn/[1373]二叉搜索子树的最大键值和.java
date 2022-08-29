
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

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        if (root == null) return 0;

        traverse(root);

        return maxSum;
    }

    public int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{
                    1,
                    Integer.MAX_VALUE,
                    Integer.MIN_VALUE,
                    0
            };
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1
                && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(root.val, left[1]);
            res[2] = Math.max(root.val, right[2]);
            res[3] = left[3] + right[3] + root.val;

            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0;
        }

        return res;
    }


    // ====================================
    public void dfs(TreeNode root) {
        if (root == null) return;

        if (!isBST(root.left) || !isBST(root.right)) {
            return;
        }

        int leftMax = getMax(root.left);
        int rightMin = getMin(root.right);

        if (root.val <= leftMax || root.val >= rightMin) {
            return;
        }

        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int rootSum = leftSum + rightSum + root.val;

        maxSum = Math.max(maxSum, rootSum);


        dfs(root.left);
        dfs(root.right);
    }

    public boolean isBST(TreeNode root) {
        if (root == null) return true;

        return isVaild(root, null, null);
    }

    public boolean isVaild(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;

        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isVaild(root.left, min, root) && isVaild(root.right, root, max);
    }

    public int getMin(TreeNode root) {
        while (root != null) {
            root = root.left;
        }
        return root.val;
    }

    public int getMax(TreeNode root) {
        while (root != null) {
            root = root.right;
        }
        return root.val;
    }

    public int getSum(TreeNode root) {
        if (root == null) return 0;

        return root.val + getSum(root.left) + getSum(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
