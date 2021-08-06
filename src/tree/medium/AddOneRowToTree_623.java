package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在二叉树中增加一行
 */
public class AddOneRowToTree_623 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        Solution solution = new AddOneRowToTree_623().new Solution();
        TreeNode addOneRow = solution.addOneRow(root, 1, 2);
        System.out.println(addOneRow.left.left.val);

    }

    class Solution {
        /*层序遍历，记录当前遍历的是哪一层，然后在指定的那一层遍历所有该层节点，创建新的一层*/
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (root == null)
                return null;

            /*当depth是1时，那么就创建新的根节点，旧的root充当新root的左子树*/
            if (depth - 1 < 1) {
                TreeNode newRoot = new TreeNode(val);
                newRoot.left = root;
                return newRoot;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int currLevel = 0;
            while (!queue.isEmpty()) {
                int currLevelSize = queue.size();
                /*记录当前层数，如果到了指定的层数，就遍历当前层的所有节点，给每一个节点创建相应的左右孩子*/
                if (++currLevel == depth - 1) {
                    for (int i = 0; i < currLevelSize; i++) {
                        TreeNode node = queue.poll();
                        TreeNode tempLeft = node.left;
                        TreeNode tempRight = node.right;
                        node.left = new TreeNode(val);
                        node.right = new TreeNode(val);
                        node.left.left = tempLeft;
                        node.right.right = tempRight;
                    }
                    break;
                } else {
                    for (int i = 0; i < currLevelSize; i++) {
                        TreeNode node = queue.poll();
                        if (node.left != null)
                            queue.offer(node.left);
                        if (node.right != null)
                            queue.offer(node.right);
                    }
                }
            }
            return root;
        }
    }

}
