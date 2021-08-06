package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值
 */
public class FindBottomLeftTreeValue_513 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        Solution solution = new FindBottomLeftTreeValue_513().new Solution();
        System.out.println(solution.findBottomLeftValue(root));
    }

    class Solution {
        /*层序遍历，每次记录每一层的最左边的那个节点*/
        public int findBottomLeftValue(TreeNode root) {
            TreeNode left = level(root);
            return left.val;
        }

        private TreeNode level(TreeNode root) {
            TreeNode left = root;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int currLevelSize = queue.size();   //记录当前层的节点个数
                left = queue.peek();                //记录当前层的第一个节点，也就是当前层最左节点

                /*循环弹出当前层所有节点*/
                for (int i = 0; i < currLevelSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
            }

            /*层序遍历结束，left指向最后一层的最左节点*/
            return left;
        }
    }
}
