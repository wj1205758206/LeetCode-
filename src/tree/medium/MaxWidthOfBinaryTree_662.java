package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大宽度
 */
public class MaxWidthOfBinaryTree_662 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(7);

        Solution solution = new MaxWidthOfBinaryTree_662().new Solution();
        System.out.println(solution.widthOfBinaryTree(root));
        //System.out.println(solution.depth(root));

    }

    class Solution {
        /**
         * 方法一：层序遍历
         * <p>
         * 这个问题中的主要想法是给每个节点一个 position 值，
         * 如果我们走向左子树，那么 position -> position * 2，
         * 如果我们走向右子树，那么 position -> positon * 2 + 1
         * 当我们在看同一层深度的位置值 L 和 R 的时候，宽度就是 R - L + 1。
         *
         * @param root
         * @return
         */
        public int widthOfBinaryTree(TreeNode root) {
            Queue<AnnotatedNode> queue = new LinkedList<>();
            queue.add(new AnnotatedNode(root, 0, 0));
            int curDepth = 0, left = 0, result = 0;

            while (!queue.isEmpty()) {
                AnnotatedNode annotatedNode = queue.poll();
                if (annotatedNode.node != null) {
                    queue.add(new AnnotatedNode(
                            annotatedNode.node.left, annotatedNode.depth + 1, annotatedNode.pos * 2));
                    queue.add(new AnnotatedNode(
                            annotatedNode.node.right, annotatedNode.depth + 1, annotatedNode.pos * 2 + 1));
                    /*对于每一个深度，第一个遇到的节点是最左边的节点，最后一个到达的节点是最右边的节点。*/
                    if (curDepth != annotatedNode.depth) {
                        curDepth = annotatedNode.depth;
                        left = annotatedNode.pos;
                    }
                    result = Math.max(result, annotatedNode.pos - left + 1);
                }
            }
            return result;
        }
    }

    class AnnotatedNode {
        TreeNode node;
        int depth, pos;

        public AnnotatedNode(TreeNode node, int depth, int pos) {
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }
}
