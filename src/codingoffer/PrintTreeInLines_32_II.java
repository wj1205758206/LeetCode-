package codingoffer;

import java.util.*;

/**
 * 分行层序遍历(BFS和DFS)
 */
public class PrintTreeInLines_32_II {
    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null)
                return lists;

            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int curLevelSize = queue.size();
                for (int i = 0; i < curLevelSize; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                lists.add(level);
            }
            return lists;
        }

        Map<Integer, List<TreeNode>> map = new HashMap<>();

        public List<List<Integer>> levelOrder2(TreeNode root) {
            List<List<Integer>> lists = new LinkedList<>();
            if (root == null)
                return lists;
            preOrder(root, 1);
            Set<Integer> set = map.keySet();
            for (Integer level : set) {
                List<Integer> list = new ArrayList<>();
                for (TreeNode treeNode : map.get(level)) {
                    list.add(treeNode.val);
                }
                lists.add(list);
            }
            return lists;
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
