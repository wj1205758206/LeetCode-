
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
    List<Integer> inorder = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        traverse(root);

        return build(inorder, 0, inorder.size() - 1);
    }

    public void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        inorder.add(root.val);
        traverse(root.right);
    }

    public TreeNode build(List<Integer> inorder, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = build(inorder, left, mid - 1);
        root.right = build(inorder, mid + 1, right);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
