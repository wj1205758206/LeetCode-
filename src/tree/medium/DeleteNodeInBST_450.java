package tree.medium;

/**
 * 删除BST中指定的节点
 */
public class DeleteNodeInBST_450 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        Solution solution = new DeleteNodeInBST_450().new Solution();
        TreeNode newRoot = solution.deleteNode(root, 3);
        System.out.println(newRoot.val);

    }

    class Solution {
        /*删除BST中指定的节点：一是找，二是删
         * 找：DFS深度优先搜素
         * 删：
         * （1）如果当前要删除的节点是叶子节点则直接删除，无需维护BST结构
         * （2）如果当前要删除的节点有左子树，则需要用该节点的前驱结点替换该节点，并删除前驱结点，以维护BST结构
         * （3）如果当前要删除的节点有右子树，则需要用该节点的后继结点替换该节点，并删除后继结点，以维护BST结构*/
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;
            if (root.val > key) {
                root.left = deleteNode(root.left, key); //当前节点大于目标值，则从左子树中找并删除
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);//当前节点小于目标值，则从右子树中找并删除
            } else {
                if (root.left == null && root.right == null) {  //找到等于目标值的节点，判断是否是叶子节点，是则直接删除
                    root = null;
                } else if (root.left != null) { //如果不是叶子节点，并且有左子树，用前驱节点替换并删除前驱节点
                    root.val = predecessor(root);
                    root.left = deleteNode(root.left, root.val);
                } else {
                    root.val = successor(root);//如果不是叶子节点，并且没有左子树而有右子树，用后继节点替换并删除后继节点
                    root.right = deleteNode(root.right, root.val);
                }
            }
            return root;
        }

        private int successor(TreeNode root) {
            root = root.right;
            while (root.left != null)
                root = root.left;
            return root.val;
        }

        private int predecessor(TreeNode root) {
            root = root.left;
            while (root.right != null)
                root = root.right;
            return root.val;
        }
    }
}
