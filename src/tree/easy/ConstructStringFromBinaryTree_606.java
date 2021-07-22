package tree.easy;

/**
 * 根据二叉树构造字符串
 */
public class ConstructStringFromBinaryTree_606 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        Solution solution = new ConstructStringFromBinaryTree_606().new Solution();
        String tree2str = solution.tree2str(root);
        System.out.println(tree2str);
    }

    class Solution {
        String treeStr = "";
        boolean flag = true;

        public String tree2str(TreeNode root) {
            if (root == null)
                return "";
            treeStr += root.val;
            if (root.left == null && root.right != null) {

                treeStr += "(";
                tree2str(root.left);
                treeStr += ")";
                flag = false;


            } else {
                if (root.left != null) {
                    treeStr += "(";
                    tree2str(root.left);
                    treeStr += ")";
                }
            }


            if (root.right != null) {
                treeStr += "(";
                tree2str(root.right);
                treeStr += ")";
            }

            return treeStr;
        }
    }
}
