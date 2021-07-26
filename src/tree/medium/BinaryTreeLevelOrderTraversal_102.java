package tree.medium;

import java.util.*;

/**
 * 二叉树的层序遍历
 */
public class BinaryTreeLevelOrderTraversal_102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new BinaryTreeLevelOrderTraversal_102().new Solution();
        List<List<Integer>> lists = solution.levelOrder2(root);
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
         * 方法一:
         * 利用先序遍历将每一个节点的层数与节点值的映射关系保存到map中
         * map的 key 是层数，value是一个List列表，保存该层的节点值
         * 然后遍历map集合取出每一层对应的节点值集合，并保存到lists大集合中
         */
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            preOrder(root, 0);
            Set<Integer> set = map.keySet();
            for (Integer level : set) {
                lists.add(map.get(level));
            }
            return lists;
        }

        private void preOrder(TreeNode root, int level) {
            if (root == null)
                return;
            if (map.containsKey(level)) {
                List<Integer> levelList = map.get(level);
                levelList.add(root.val);
            } else {

                List<Integer> levelList = new ArrayList<>();
                levelList.add(root.val);
                map.put(level, levelList);

            }
            if (root.left != null)
                preOrder(root.left, level + 1);
            if (root.right != null)
                preOrder(root.right, level + 1);
        }

        /**
         * 方法二：
         * BFS广度优先搜素进行层次遍历
         * 首先是根元素入队
         * 然后根据当前队列的长度，取出所有元素，这些元素就是该层的节点，保存到当前层的列表level中
         * 取出该层所有的节点遍历的同时判断该节点是否有左右孩子，如果有就把左右孩子入队
         * 当队列为空时，也就遍历完了所有节点
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder2(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;

            /*维护一个队列用来保存层次遍历的节点*/
            Queue<TreeNode> queue = new LinkedList<>();

            /*首先根节点入队*/
            queue.offer(root);

            /*当队列不为空时，说明还没有遍历完最后一层的节点*/
            while (!queue.isEmpty()) {
                /*每一层都创建对应的level集合，保存该层的所有节点*/
                List<Integer> level = new ArrayList<>();

                /*当前队列的大小就等于该层的所有节点的个数
                 * 遍历当前层的所有节点，弹出队首节点保存到列表中
                 * 如果当前节点有左右孩子，就把孩子加入到队列中
                 * 当前层的节点遍历完，队列中也就有了当前层所有的节点的孩子，即队列中也就从左到右保存了下一层所有的节点*/
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                result.add(level);
            }
            return result;
        }

    }
}
