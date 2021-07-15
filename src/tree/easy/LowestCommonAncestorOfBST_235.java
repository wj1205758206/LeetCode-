package tree.easy;

/**
 * 计算BST中两个节点的最近的公共父节点
 */
public class LowestCommonAncestorOfBST_235 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution solution = new LowestCommonAncestorOfBST_235().new Solution();
        TreeNode node = solution.lowestCommonAncestor(root, root.left, root.right);
        System.out.println(node.val);


    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            /*基准条件*/
            if (root == null)
                return null;
            /*如果这两个节点分别位于当前root节点的左右子树中，那么root节点就是最近的公共祖先*/
            if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val))
                return root;
            /*如果这两个节点其中一个节点等于了当前递归的root节点，说明另一个节点是这个节点的后代，说明最近的公共祖先就是这个root*/
            if (p.val == root.val || q.val == root.val)
                return p;
            /*以上条件都不满足的话，说明这两个节点全部位于root的左子树或者右子树，
            如果小于当前root节点值，那么使用递归定义，从左子树中找最近的公共祖先
            如果大于当前root节点值，那么使用递归定义，从右子树中找最近的公共祖先
            */
            if (p.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            return lowestCommonAncestor(root.right, p, q);

        }
    }
}
