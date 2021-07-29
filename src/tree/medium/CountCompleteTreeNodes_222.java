package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树的节点个数
 */
public class CountCompleteTreeNodes_222 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        Solution solution = new CountCompleteTreeNodes_222().new Solution();
        System.out.println(solution.countNodes2(root));

    }

    class Solution {
        /**
         * 方法一：BFS广度优先搜搜，层次遍历，累加每一层的节点个数
         *
         * @param root
         * @return
         */
        public int countNodes(TreeNode root) {
            if (root == null)
                return 0;
            int sum = 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();
                sum += currentLevelSize;
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
            }
            return sum;
        }

        /**
         * 方法二：DFS深度优先搜索，直接遍历每一个节点，累加个数
         */
        int sum = 0;

        public int countNodes2(TreeNode root) {
            return DFS(root);
        }

        private int DFS(TreeNode root) {
            if (root == null)
                return 0;


            DFS(root.left);
            DFS(root.right);

            return sum;
        }
    }
}
