package codingoffer;

import java.util.*;

/**
 * 层序遍历(BFS和DFS)
 */
public class PrintTreeFromTopToBottom_32 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * BFS
         *
         * @param root
         * @return
         */
        public int[] levelOrder(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null)
                return new int[0];

            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {

                int curLevelSize = queue.size();
                for (int i = 0; i < curLevelSize; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        /**
         * DFS
         */
        Map<Integer, List<TreeNode>> map = new HashMap<>();

        public int[] levelOrder2(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            preOrder(root, 1);
            Set<Integer> set = map.keySet();
            for (Integer level : set) {
                for (TreeNode node : map.get(level)) {
                    list.add(node.val);
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        private void preOrder(TreeNode root, int level) {
            if (root == null)
                return;

            if (map.containsKey(level)) {
                map.get(level).add(root);
            } else {
                map.put(level, new ArrayList<>());
                map.get(level).add(root);
            }
            preOrder(root.left, level + 1);
            preOrder(root.right, level + 1);
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
