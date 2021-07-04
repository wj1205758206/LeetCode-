package tree.medium;

/**
 * 调整被错误交换的两个节点，恢复BST结构
 */
public class RecoverBST_99 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);

        Solution solution = new Solution();
        solution.recoverTree(root);

        System.out.println(root.left.val);

    }

    static class Solution {
        /*pre用来记录上一层递归的root节点，实际上是记录中序遍历的前驱节点
         * first和second分别记录错误的两个节点*/
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;

        /**
         * 要想恢复BST结构，首先要找到出错的那两个节点
         * 借助BST中序遍历的性质，找到错误的两个节点，并交换两个节点的值
         *
         * @param root 根节点
         */
        public void recoverTree(TreeNode root) {
            inorder(root);
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        /**
         * 中序遍历是升序的，使用prev记录前驱节点
         * 如果存在前驱结点，并且前驱节点的值大于了此次递归遍历的root节点的值，即左孩子的值大于了父节点的值，说明这个前驱节点出错了
         *
         * @param root
         */
        public void inorder(TreeNode root) {
            if (root == null)
                return;
            inorder(root.left);

            if (prev != null && prev.val > root.val) {

                /*当左孩子大于父节点时，这里还需要判断是否已经找到了第一个出错的节点，
                 * 如果还没有找到第一个出错的节点，那么第一个大于父节点的左孩子就是出错的第一个节点first
                 * 如果之后的递归遍历中又出现了左孩子比父节点大的情况，就无需再记录这个左孩子，而是需要记录本次递归的root节点，
                 * 这个root节点就是出错的第二个节点*/
                if (first == null) {
                    first = prev;
                }
                second = root;
            }

            /*更新prev的值，保证prev是每次递归root的前驱节点，用来判断是否破坏了BST的性质*/
            prev = root;

            inorder(root.right);
        }
    }
}
