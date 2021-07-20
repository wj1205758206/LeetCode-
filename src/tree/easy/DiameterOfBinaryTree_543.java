package tree.easy;

/**
 * 计算二叉树之间任意两个节点之间最长的路径
 */
public class DiameterOfBinaryTree_543 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution solution = new DiameterOfBinaryTree_543().new Solution();
        System.out.println(solution.diameterOfBinaryTree(root));

    }

    class Solution {
        /*任意两个节点之间的最长路径，分两种情况，一种是过root根节点，一种是不过root根节点
         * 过root根节点的情况，最长路径是左右子树最大深度之和，即为最长路径
         * 不过root根节点的情况，说明在root的左子树或者右子树中存在更长的路径
         * 两种情况二者取最大值*/
        public int diameterOfBinaryTree(TreeNode root) {
            /*基准条件*/
            if (root == null)
                return 0;
            /*记录当前root节点左右子树最大深度分别是多少，可求出过root节点的最长路径*/
            int lMaxDepth = getMaxDepth(root.left);
            int rMaxDepth = getMaxDepth(root.right);

            /*使用递归定义，计算当前root左右子树的最大直径是多少*/
            int ldiameter = diameterOfBinaryTree(root.left);
            int rdiameter = diameterOfBinaryTree(root.right);

            /*两种情况取最大值
             * 过root节点的情况：左子树最大深度+右子树最大深度
             * 不过root节点的情况：max(左子树的直径，右子树的直径)*/
            return Math.max(lMaxDepth + rMaxDepth, Math.max(ldiameter, rdiameter));
        }

        private int getMaxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;

        }
    }
}
