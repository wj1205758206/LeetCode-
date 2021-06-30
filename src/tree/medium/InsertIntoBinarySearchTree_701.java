package tree.medium;

/**
 * 在二叉搜索树中插入一个数
 */
public class InsertIntoBinarySearchTree_701 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        Solution solution = new Solution();
        TreeNode insertIntoBST = solution.insertIntoBST(root, 5);
        System.out.println(insertIntoBST.right.left.val);
    }

    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            /*向二叉搜索树中插入一个数，首先是“找”，即根据二叉搜索树的性质找到合适和插入位置，然后是“插”，插入的位置一定是在叶子结点后面
            * root==null也就是找到了合适的位置，需返回要插入的节点*/
            if (root == null)
                return new TreeNode(val);

            /*如果还没有找到合适的插入位置，此时判断val与当前root的值的大小
            * 如果比root大，则需要搜索右子树并找到合适的位置，返回的节点就是当前root的右孩子
            * 如果比root小，则需要搜索左子树并找到合适的位置，返回的节点就是当前root的左孩子*/
            if (root.val < val)
                root.right = insertIntoBST(root.right, val);
            if (root.val > val)
                root.left = insertIntoBST(root.left, val);

            return root;
        }
    }
}
