package tree.medium;

import java.util.Arrays;

/**
 * 根据前序和后序遍历构造二叉树
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal_889 {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal_889().new Solution();
        TreeNode root = solution.constructFromPrePost(preorder, postorder);
        System.out.println(root.val);
    }

    class Solution {
        /**
         * 递归划分左右子树
         * 前序：（root）（左子树集合）（右子树集合）
         * 后序：（左子树集合）（右子树集合）（root）
         *
         * @param preorder
         * @param postorder
         * @return
         */
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            if (preorder.length == 0)
                return null;

            /*前序遍历的第一个元素就是要构造的当前root节点*/
            TreeNode root = new TreeNode(preorder[0]);

            /*如果递归遍历当前前序遍历集合长度为1了，则直接返回构造出来的当前root节点
             * 否则继续划分构造左右子树*/
            if (preorder.length == 1)
                return root;

            /*根据前序遍历集合计算划分左右子树的分割点*/
            int fengePoint = 0;
            for (int i = 0; i < postorder.length; i++) {
                if (preorder[1] == postorder[i])
                    fengePoint = i + 1;
            }

            /*递归改造左右子树*/
            root.left = constructFromPrePost(
                    Arrays.copyOfRange(preorder, 1, 1 + fengePoint),
                    Arrays.copyOfRange(postorder, 0, fengePoint));

            root.right = constructFromPrePost(
                    Arrays.copyOfRange(preorder, 1 + fengePoint, preorder.length),
                    Arrays.copyOfRange(postorder, fengePoint, postorder.length - 1));

            return root;
        }
    }
}
