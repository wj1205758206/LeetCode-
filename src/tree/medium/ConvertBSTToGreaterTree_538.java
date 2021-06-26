package tree.medium;

/**
 * 把二叉搜索树转换为累加树
 */
public class ConvertBSTToGreaterTree_538 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        Solution solution = new Solution();
        TreeNode convertBST = solution.convertBST(root);
        System.out.println(convertBST.left.val);
    }

    static class Solution {

        /**
         * 维护一个外部累加变量
         * 利用中序遍历的性质，只不过先递归遍历右子树，然后在递归左子树，这样结果是降序的
         * 累加比当前节点大的节点的值，然后再赋值给当前节点
         */
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root == null)
                return null;

            convertBST(root.right);

            sum += root.val;
            root.val = sum;

            convertBST(root.left);
            return root;
        }
    }
}
