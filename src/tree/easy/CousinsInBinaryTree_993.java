package tree.easy;


/**
 * 计算二叉树中两个节点是否是表亲节点(同层不同父节点)
 */
public class CousinsInBinaryTree_993 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        Solution solution = new CousinsInBinaryTree_993().new Solution();
        System.out.println(solution.isCousins(root, 5, 4));
        System.out.println(solution.depth(root, 3, 0));

    }

    /*判断两个节点是否是表亲节点
     * 第一：相同深度(depth求节点深度)
     * 第二：不同父节点(isSameParent判断是否是同父节点)*/
    class Solution {
        int xHeight = 0;
        int yHeight = 0;

        public boolean isCousins(TreeNode root, int x, int y) {
            /*当这两个节点具有相同深度，并且不是同一个父节点时，才是表亲节点*/
            if (depth(root, x, xHeight) == depth(root, y, yHeight) && !isSameParent(root, x, y))
                return true;
            return false;
        }

        private boolean isSameParent(TreeNode root, int x, int y) {
            if (root == null)
                return false;
            /*判断是否是同父节点
             * 如果当前root的左孩子是x，右孩子是y，那么是同父节点
             * 还需要递归判断左子树和右子树，*/
            return ((root.left != null && root.right != null && root.left.val == x && root.right.val == y) ||
                    (root.left != null && root.right != null && root.left.val == y && root.right.val == x) ||
                    isSameParent(root.left, x, y) || isSameParent(root.right, x, y));

        }

        private int depth(TreeNode root, int val, int height) {
            if (root == null)
                return 0;
            /*如果找到了，就返回当前height*/
            if (root.val == val)
                return height;

            /*判断是否在左子树中存在val，若存在该节点并返回*/
            int deep = depth(root.left, val, height + 1);
            if (deep != 0)
                return deep;

            /*否则，这个节点存在于右子树中，并返回*/
            return depth(root.right, val, height + 1);
        }
    }
}
