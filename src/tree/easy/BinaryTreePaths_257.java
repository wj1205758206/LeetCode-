package tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出所有从根节点到叶子节点的所有路径
 */
public class BinaryTreePaths_257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        Solution solution = new BinaryTreePaths_257().new Solution();
        List<String> strings = solution.binaryTreePaths(root);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    class Solution {
        List<String> list = new ArrayList<>();

        /*
         * 输出所有从根节点到叶子节点的所有路径，就是找二叉树中的所有叶子节点
         * 创建一个字符串，使用递归定义不断拼接左右子树的节点值，直到找到一个叶子节点为止*/
        public List<String> binaryTreePaths(TreeNode root) {
            getPaths(root, root.val + "");
            return list;
        }

        private void getPaths(TreeNode root, String path) {
            /*基准条件*/
            if (root == null)
                return;
            /*找到叶子节点，此时path就是一条从root到leaf的一条路径，将path添加到list中
            * 找到叶子节点就直接return即可，无需继续查找*/
            if (root.left == null && root.right == null) {
                list.add(path);
                return;
            }

            /*如果左孩子或者右孩子不为空，就递归拼接path*/
            if (root.left != null)
                getPaths(root.left, path + "->" + root.left.val);
            if (root.right != null)
                getPaths(root.right, path + "->" + root.right.val);

        }
    }
}
