package tree.easy;

/**
 * 判断是否为结构和节点值都相同的两棵二叉树
 */
public class SameTree_100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        Solution solution = new Solution();
        solution.isSameTree(p, q);
    }

    static class Solution {
        /**
         * 要保证树的结构和每一个节点的值都相同，可以通过先序遍历，比较每一个节点的以及左右孩子节点的值是否都相同
         * 不能使用中序遍历去判断，因为不同结构的二叉树，有可能中序遍历出的结果是一样的，因此中序遍历无法保证结构也相同
         * 所以只能先序遍历一个一个节点去比较
         *
         * @param p 第一个树的根节点
         * @param q 第二棵树的根节点
         * @return 返回是否是结构以及每一个节点都相同的二叉树
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null)
                return true;
            if ((p != null && q == null) || (p == null && q != null) || (p.val != q.val))
                return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
