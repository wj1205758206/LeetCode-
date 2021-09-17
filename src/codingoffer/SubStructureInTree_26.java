package codingoffer;

/**
 * 树的子结构(判断一棵树是否包含另一棵树的)
 */
public class SubStructureInTree_26 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);

        Solution solution = new SubStructureInTree_26().new Solution();
        System.out.println(solution.isSubStructure(root, root2));
    }

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            //如果与任何一棵树是null，不用比较直接返回false
            if (A == null || B == null)
                return false;

            /*我们从当前两棵树的根节点开始比较，判断树A是否包含B
             * 如果当前A不含B，那么就分别从当前树A的左右子树区判断是否子树中包含B
             * 只有有一个条件为真，就说明A树包含B树*/
            return hasSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean hasSubTree(TreeNode a, TreeNode b) {
            //遍历比较的过程中，如果b==null，说明b树遍历完了，返回真
            if (b == null)
                return true;

            //如果b树还没遍历完，a就先遍历完了，那么当前子树a中不含b树
            if (a == null)
                return false;

            //如果当前节点相等，就遍历这两棵树的左右节点是否相等
            return a.val == b.val && hasSubTree(a.left, b.left) && hasSubTree(a.right, b.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
