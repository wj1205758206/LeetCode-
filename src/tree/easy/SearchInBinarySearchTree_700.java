package tree.easy;

/**
 * 二叉搜索树的搜索
 */
public class SearchInBinarySearchTree_700 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(3);

        Solution solution = new Solution();
        TreeNode searchBST = solution.searchBST(root, 2);
        System.out.println(searchBST.val);

    }

    static class Solution {
        /**
         * 根据二叉搜索树的性质，遍历子树，
         *
         * @param root
         * @param val
         * @return
         */
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null)
                return null;
            if (root.val == val)
                return root;
            else if (root.val > val)
                return searchBST(root.left, val);
            else
                return searchBST(root.right, val);

        }
    }
}
