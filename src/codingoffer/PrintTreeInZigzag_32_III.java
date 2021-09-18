package codingoffer;

import java.util.*;

/**
 * 之字形层序遍历
 */
public class PrintTreeInZigzag_32_III {
    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null)
                return lists;

            boolean isOdd = true;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Deque<Integer> level = new ArrayDeque<>();
                int curLevelSize = queue.size();
                for (int i = 0; i < curLevelSize; i++) {
                    TreeNode node = queue.poll();
                    if (isOdd) {
                        level.addLast(node.val);
                    } else {
                        level.addFirst(node.val);
                    }
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                isOdd = !isOdd;
                List<Integer> list = new ArrayList<>();
                for (Integer val : level) {
                    list.add(val);
                }
                lists.add(list);
            }
            return lists;
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
