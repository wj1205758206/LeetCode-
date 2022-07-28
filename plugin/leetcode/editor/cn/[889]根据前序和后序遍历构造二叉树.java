
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0 || postorder.length == 0) return null;

        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];
        int indexLeft = getIndexLeft(postorder, leftRootVal);
        int leftSize = indexLeft - postStart + 1;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, indexLeft);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, indexLeft + 1, postEnd - 1);

        return root;
    }

    public int getIndexLeft(int[] postorder, int leftRootVal) {
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] == leftRootVal) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
