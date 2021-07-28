package tree.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 计算二叉树中路径和等于目标值的所有路径
 */
public class PathSum_II_113 {
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

        Solution solution = new PathSum_II_113().new Solution();
        List<List<Integer>> lists = solution.pathSum2(root, 22);
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.println("]");
        }
    }

    class Solution {
        /**
         * 方法一：DFS深度优先搜索，递归遍历
         */
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {


            if (root == null)
                return result;

            DFS(root, targetSum);

            return result;
        }

        private void DFS(TreeNode root, int targetSum) {
            /*需要记录从root到leaf的路径*/
            path.add(root.val);

            /*将目标值不断递减当前节点值
             * 如果遍历到了叶子结点并且目标值同时也减少为0，说明存在一条路径*/
            targetSum -= root.val;
            if (root.left == null && root.right == null && targetSum == 0) {
                /*在result集合中新建一个集合并保存当前的这条路径，必须新建一个列表同时赋值这条路径，path只是一个共享用来记录当前遍历路径*/
                result.add(new ArrayList<>(path));
            }
            if (root.left != null)
                DFS(root.left, targetSum);
            if (root.right != null)
                DFS(root.right, targetSum);

            /*每次递归完左右子树要回退上一分支路径，移除当前路径中最后一个节点*/
            path.remove(path.size() - 1);

        }


        /**
         * 方法二：BFS广度优先搜索
         */
        List<List<Integer>> res = new ArrayList<>();

        /*需要用一个map集合来保存当前节点以及他的父节点*/
        Map<TreeNode, TreeNode> map = new HashMap<>();

        public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {

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
                    if (rec == targetSum) {
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

}
