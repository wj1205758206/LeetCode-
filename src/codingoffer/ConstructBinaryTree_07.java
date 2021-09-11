package codingoffer;

/**
 * 构造二叉树
 */
public class ConstructBinaryTree_07 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTree_07().new Solution();
        TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode.left.val);
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0)
                return null;

            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd)
                return null;

            //先序数组的第一个元素即为当前递归要创建的节点的val值
            int rootVal = preorder[preStart];
            //根据val从中序数组找出左右子树的分割点
            int index = getIndex(rootVal, inorder);
            //计算左子树长度，好切分先序和中序数组
            int leftSize = index - inStart;

            TreeNode root = new TreeNode(rootVal);
            //递归构造左子树
            root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
            //递归构造右子树
            root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);

            return root;
        }

        private int getIndex(int rootVal, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootVal)
                    return i;
            }
            return -1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
