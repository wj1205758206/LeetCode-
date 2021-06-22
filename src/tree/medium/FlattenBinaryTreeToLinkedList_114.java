package tree.medium;

/**
 * 将二叉树展开为链表
 */
public class FlattenBinaryTreeToLinkedList_114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Solution solution = new Solution();
        solution.flatten(root);
        System.out.println(root.right.right.val);

    }

    static class Solution {
        public void flatten(TreeNode root) {
            /*如果当前递归root节点为null，就直接返回，无需展开链表*/
            if (root == null)
                return;

            /*先递归展开当前root节点的左右孩子链表*/
            flatten(root.left);
            flatten(root.right);

            /*展开当前root节点的左右孩子链表之后，先拆下root已经展开的右分支
            * 将展开的做分支怼到root的右分支
            * 左分支置为null*/
            TreeNode treeNode = root.right;
            root.right = root.left;
            root.left = null;

            /*将拆下来的已经展开的原来右分支连接在现在的右分支的尾部*/
            TreeNode flag = root;
            while (flag.right != null)
                flag = flag.right;
            flag.right = treeNode;

        }
    }
}
