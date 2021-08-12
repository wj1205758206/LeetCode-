package tree.medium;

/**
 * 最长同值路径
 */
public class LongestUnivaluePath_687 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        Solution solution = new LongestUnivaluePath_687().new Solution();
        System.out.println(solution.longestUnivaluePath(root));
    }

    class Solution {
        int result = 0;//维护一个全局变量，保存返回的最长同值路径的长度

        public int longestUnivaluePath(TreeNode root) {
            longestPath(root);
            return result;
        }

        private int longestPath(TreeNode root) {
            if (root == null)
                return 0;

            /*longestPath函数是用来计算一个子树可以向上层父节点提供的最大同值路径长度*/
            int leftLongestPath = longestPath(root.left);
            int rightLongestPath = longestPath(root.right);

            /*每个节点都会维护这两个变量，用来计算从当前root开始，左右链的长度，
             *如果当前root和左右孩子的值都不相等，那么就相当于当前root和左右孩子断开连接了
             * 所以当前root的最大同值长度就为0，因为没有边和当前root相连*/
            int left = 0;
            int right = 0;

            /*如果当前root和左右孩子的值相等，那么就在左右子树提供上来的最大同值路径长度的基础上再加1*/
            if (root.left != null && root.left.val == root.val)
                left = leftLongestPath + 1;
            if (root.right != null && root.right.val == root.val)
                right = rightLongestPath + 1;

            /*left和right有可能都为0，即当前root和左右孩子都断开连接
             * 也有可能当前root和左孩子或者右孩子相连接，那么说明left、right不为0，
             * 需要计算经过当前root的最大同值路径长度，即left+right，更新全局最大同值路径长度*/
            result = Math.max(result, left + right);

            /*向上层父节点返回的是左右子树中较大的那个，如果恰巧和父节点值也相等，那么路径加1，就能保证计算出从指定的父节点开始
             * 所能找到的最长同值路径长度*/
            return Math.max(left, right);
        }
    }
}
