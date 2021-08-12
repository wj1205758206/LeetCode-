package tree.medium;

/**
 * 剪枝BST
 */
public class TrimBST_669 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        //root.left.right = new TreeNode(2);
        //root.left.right.left = new TreeNode(1);

        Solution solution = new TrimBST_669().new Solution();
        TreeNode newRoot = solution.trimBST(root, 1, 2);
        System.out.println(newRoot.val);


    }

    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null)
                return null;
            if (root.val < low)
                return trimBST(root.right, low, high);
            if (root.val > high)
                return trimBST(root.left, low, high);
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}