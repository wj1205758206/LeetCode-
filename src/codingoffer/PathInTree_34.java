package codingoffer;

import java.util.*;

/**
 * 打印路径和
 */
public class PathInTree_34 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Solution solution = new PathInTree_34().new Solution();
        System.out.println(solution.pathSum2(root, 22));
    }

    class Solution {
        List<List<Integer>> lists = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null)
                return lists;
            List<Integer> path = new ArrayList<>();

            DFS(root, 0, path, target);

            return lists;
        }

        private void DFS(TreeNode root, int sum, List<Integer> path, int target) {
            //######先序遍历#########
            path.add(root.val);
            sum += root.val;

            if (root.left == null && root.right == null && sum == target) {
                lists.add(new ArrayList<>(path));
            }
            //######先序遍历#########

            if (root.left != null)
                DFS(root.left, sum, path, target);
            if (root.right != null)
                DFS(root.right, sum, path, target);

            path.remove(path.size() - 1);
        }

        List<List<Integer>> res = new ArrayList<>();

        Map<TreeNode, TreeNode> map = new HashMap<>();

        public List<List<Integer>> pathSum2(TreeNode root, int target) {
            if (root == null)
                return res;

            Queue<TreeNode> queueNode = new LinkedList<>();

            /*queueSum队列用来保存当前已经遍历过的节点值的累加值*/
            Queue<Integer> queueSum = new LinkedList<>();

            queueNode.offer(root);
            queueSum.offer(0);

            while (!queueNode.isEmpty()) {
                TreeNode node = queueNode.poll();

                /*更新累加值*/
                int rec = queueSum.poll() + node.val;

                if (node.left == null && node.right == null) {
                    if (rec == target) {
                        getPath(node);
                    }
                } else {
                    if (node.left != null) {
                        /*保存当前节点以及父节点*/
                        map.put(node.left, node);
                        queueNode.offer(node.left);
                        queueSum.offer(rec);
                    }
                    if (node.right != null) {
                        map.put(node.right, node);
                        queueNode.offer(node.right);
                        queueSum.offer(rec);
                    }
                }
            }
            return res;
        }

        private void getPath(TreeNode node) {
            List<Integer> temp = new ArrayList<>();

            /*根据map集合不断向上找父节点，得出的路径是倒序的，需要逆置*/
            while (node != null) {
                temp.add(node.val);
                node = map.get(node);
            }
            Collections.reverse(temp);
            res.add(temp);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
