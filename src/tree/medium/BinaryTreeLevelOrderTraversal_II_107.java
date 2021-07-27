package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的自底向上层序遍历
 */
public class BinaryTreeLevelOrderTraversal_II_107 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution solution = new BinaryTreeLevelOrderTraversal_II_107().new Solution();
        List<List<Integer>> lists = solution.levelOrderBottom(root);
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
         * 改造基础的DFS层序遍历，每一层的节点集合，采用头插法保存在大集合result中
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null)
                return result;

            DFS(root, 0, result);

            return result;
        }

        private void DFS(TreeNode node, int level, List<List<Integer>> result) {
            /*改造每一层的遍历顺序，而不是每一层中每个节点的遍历顺序
             * 新创建的层数采用头插法放入result结果集中，进而保证自底向上倒序输出每层节点值*/
            if (level == result.size()) {
                result.add(0, new ArrayList<>());
            }

            /*每一次添加节点值，要与对应的层数保持一致，因为倒序所以层数索引为 size-level-1 */
            result.get(result.size() - level - 1).add(node.val);

            if (node.left != null)
                DFS(node.left, level + 1, result);
            if (node.right != null)
                DFS(node.right, level + 1, result);
        }

        /**
         * 方法二：使用队列迭代进行遍历
         * 改造基础的层序遍历，使其自顶向上的输出每层节点值
         * 需要改变的是每层节点集合，加入到result结果集中的索引位置，采用头插法保证是倒序
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrderBottom2(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int currentLevelSize = queue.size();

                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                /*每一层添加节点值的顺序无需改动
                 *需要修改的是结果集保存每层集合level的顺序，采用头插法保证倒序*/
                result.add(0, level);
            }
            return result;
        }
    }
}
