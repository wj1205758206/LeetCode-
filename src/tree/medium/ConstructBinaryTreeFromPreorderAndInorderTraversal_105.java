package tree.medium;

import java.util.Arrays;

/**
 * 通过前序遍历和中序遍历构造二叉树
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree2(preorder, inorder);

        System.out.println(root.right.left.val);

    }

    static class Solution {
        /**
         * 方法一：先判断root节点需要进行什么操作，然后使用递归定义，递归操作剩余的左右子树
         */
        public int count = 0;   //count记录当前递归中，前序遍历数组第一个值，即找出划分左右子树的分割节点

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            /* 基准条件
             * 划分出的子树已经没有节点了，不用再继续构造节点，就直接返回null*/
            if (inorder.length == 0)
                return null;
            /*从前序遍历数组中取出当前递归的分割左右子树的分割节点，并创建出这个分割节点*/
            int val = preorder[count++];
            TreeNode root = new TreeNode(val);
            /*在中序遍历数组中确定分割节点的索引位置，即划分出本次递归的左右子树*/
            int index = index(inorder, val);

            /*递归遍历左右子树，不断构root节点，作为上一层递归的左右孩子节点
             * 传入preorder，由于count遍历自增，所以每次递归都可以找出分隔节点
             * 索引index划分出左右子树，左右子树数组充当下一次递归的中序遍历数组*/
            root.left = buildTree(preorder, Arrays.copyOfRange(inorder, 0, index));
            root.right = buildTree(preorder, Arrays.copyOfRange(inorder, index + 1, inorder.length));

            return root;
        }

        public int index(int[] nums, int num) {
            int index = -1;
            for (int i = 0; i < nums.length; i++) {
                if (num == nums[i]) {
                    index = i;
                    break;
                }
            }
            return index;
        }

        /**
         * 方法二：另外创建一个辅助函数，传入前序遍历数组、中序遍历数组、以及对应数组的索引起始位置
         *
         * @param preorder 前序遍历数组
         * @param inorder  中序遍历数组
         * @return 返回构造出来二叉树的根节点
         */
        public TreeNode buildTree2(int[] preorder, int[] inorder) {
            /*构造一个辅助函数，这样将每次递归的左右子树的起点和终点位置可以当做参数传入
            * 根据前序遍历和中序遍历的性质，每次递归可以根据前序遍历数组确定一个分割节点，从中序遍历数组中分割出左右子树
            * 分割出来的左子树对应本次递归前序遍历分割点之后的那几个元素，剩余的就是右子树*/
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            /*基准条件*/
            if (preStart > preEnd)
                return null;

            /*root节点对应的值就是前序遍历数组中的第一个元素*/
            int rootVal = preorder[preStart];

            /*找出root节点在中序遍历数组中的索引*/
            int index = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    index = i;
                    break;
                }
            }

            /*确定本次递归左子树的长度，前序遍历数组中剩余的就是右子树*/
            int leftSize = index - inStart;

            /*创造出本次递归遍历的root节点*/
            TreeNode root = new TreeNode(rootVal);

            /*递归构造左右子树，每次递归传入上次递归分割出来的左右子树起点和终点，以及对应的中序遍历数组起点和终点
            * 相当于始终传入原始的前序遍历数组和中序遍历数组，变的只是前序遍历数组和中序遍历数组的起点和终点位置
            * 通过改变起点和终点位置，模拟出分割出来的左右子树*/
            root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
            root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);

            return root;
        }
    }
}
