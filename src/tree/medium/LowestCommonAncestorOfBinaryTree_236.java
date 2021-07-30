package tree.medium;

/**
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestorOfBinaryTree_236 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 方法一：递归遍历
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            /*基准条件*/
            if (root == null)
                return null;
            /*如果其中一个节点就是root根节点，那么另一个节点就是这个节点的左子树或者右子树
             * 所以root就是这两个节点的最近公共祖先*/
            if (root == p || root == q)
                return root;

            /*后序遍历，自底向上找最近公共祖先
             * 先看左子树是否存在最近公共祖先，再看右子树是否存在最近公共祖先
             * 因为是递归，使用函数后可认为左右子树已经算出结果*/
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            /*如果左右都找到，说明pq分别位于当前root的左右两侧，那么root就是最近公共祖先*/
            if (left != null && right != null)
                return root;

            /*此时若left为空，那最终结果只要看 right；若 right 为空，那最终结果只要看 left*/
            return left != null ? left : right;
        }
    }
}
