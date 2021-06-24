package tree.medium;

/**
 * 通过后序遍历和中序遍历构造二叉树
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(inorder, postorder);

        System.out.println(root.right.left.val);

    }

    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            /*基准条件*/
            if (inStart > inEnd)
                return null;
            // root 节点对应的值就是后序遍历数组的最后一个元素
            int rootVal = postorder[postEnd];

            // rootVal 在中序遍历数组中的索引
            int index = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    index = i;
                    break;
                }
            }

            TreeNode root = new TreeNode(rootVal);

            // 左子树的节点个数
            int leftSize = index - inStart;
            // 递归构造左右子树
            root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
            root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

            return root;
        }
    }
}
