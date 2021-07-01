package tree.medium;

/**
 * 删除二叉搜索树中指定的元素
 */
public class DeleteNodeBST_450 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);

        Solution solution = new Solution();
        TreeNode treeNode = solution.deleteNode(root, 2);
        System.out.println(treeNode.left.val);

    }

    static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            /*基准元素，如果是根节点为空或者递归到了叶子结点的下一层，就直接返回null*/
            if (root == null)
                return null;

            /*如果当前根节点root的值等于key，则进行删除结点的操作*/
            if (root.val == key) {
                /*情况1:
                * 如果当前要删除的节点恰好是末端节点，即两个子节点都为空，则可以直接进行删除，不会破坏二叉搜索树的性质*/
                if (root.left == null && root.right == null)
                    return null;

                /*情况2：
                * 如果当前要删除的节点只有一个孩子节点，就返回这个孩子节点，让孩子节点替代删除的节点*/
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;

                /*情况3:
                * 如果当前要删除的节点左右孩子同时存在
                * 要想维持二叉搜索树的性质，必须要找到当前节点左子树中最大的节点(前驱节点)，或者当前节点右子树中最小的节点(后继节点)
                * 让前驱节点或者后继节点来替代当前根节点root的位置
                * */
                if (root.left != null && root.right != null) {
                    //TreeNode minNode = getMin(root.right);
                    /*以找前驱节点为例，找到左子树中最大的值，root节点的值更改为这个最大值
                    * 这个左子树最大值已经替代了原来的root节点的值，所有整棵树中没有了root节点的值，而这个左子树最大值有两个一样的值，
                    * 所以，最后在左子树中找到这个多余的最大值节点并删除
                    * */
                    TreeNode maxNode = getMax(root.left);
                    root.val = maxNode.val;
                    root.left = deleteNode(root.left, maxNode.val);
                }
            /*如果当前根节点root的值大于key，那就递归从左子树中进行删除操作
            * 如果当前根节点root的值小于key，那就递归从右子树中进行删除操作*/
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            }

            return root;
        }

        /**
         * 获取左子树中最大值函数
         * @param root  传入的子树的根节点
         * @return      返回左子树中最大值
         */
        public TreeNode getMax(TreeNode root) {
            TreeNode maxNode = root;
            while (maxNode.right != null) {
                maxNode = maxNode.right;
            }
            return maxNode;
        }

        /**
         * 获取右子树中最小值函数
         * @param root  传入的子树的根节点
         * @return      返回右子树中最小值
         */
        public TreeNode getMin(TreeNode root) {
            TreeNode minNode = root;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            return minNode;
        }

    }
}
