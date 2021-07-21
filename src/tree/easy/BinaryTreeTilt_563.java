package tree.easy;

/**
 * 计算二叉树中所有节点的tilt之和
 */
public class BinaryTreeTilt_563 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        Solution solution = new BinaryTreeTilt_563().new Solution();
        int tilt = solution.findTilt(root);
        System.out.println(tilt);

    }

    class Solution {

        int sumTilt = 0;


        public int findTilt(TreeNode root) {
            if (root == null)
                return 0;

            sumTilt += tilt(root);
            findTilt(root.left);
            findTilt(root.right);

            return sumTilt;
        }


        private int tilt(TreeNode root) {
            if (root == null)
                return 0;
            return Math.abs(subSum(root.left) - subSum(root.right));

        }

        private int subSum(TreeNode root) {
            if (root == null)
                return 0;
            return root.val + subSum(root.left) + subSum(root.right);
        }
    }

}
