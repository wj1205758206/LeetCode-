
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        if (root.val >= p.val && root.val <= q.val){
            return root;
        }

        if (root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return lowestCommonAncestor(root.right, p ,q);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
