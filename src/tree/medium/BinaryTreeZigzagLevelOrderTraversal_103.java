package tree.medium;

import java.util.*;

/**
 * 二叉树的蛇形层序遍历
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Solution solution = new BinaryTreeZigzagLevelOrderTraversal_103().new Solution();
        List<List<Integer>> lists = solution.zigzagLevelOrder3(root);
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
         * 方法一：使用双端队列实现奇偶行层次蛇形输出
         * <p>
         * 需要对基础的层序遍历进行改造，将原来的使用 List<Integer> 来保存每一层节点，改成使用双端队列 Deque<Integer>
         * 需要根据当前的层数的奇偶，来决定从双端队列的哪一端放入节点值
         * 换句话说，根据当前的是奇数层还是偶数层，来决定采用头插法还是尾插法
         * 孩子节点还是正常的从左到右的放入queue队列中，但是遍历当前层的时，该层的所有节点值放入该层双端队列的方式与奇偶层数有关
         *
         * @param root
         * @return
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isLeft = true;
            while (!queue.isEmpty()) {
                Deque<Integer> level = new LinkedList<>();
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();

                    /*主要的是这段代码与基础层序遍历不同
                     * 需要根据isLeft标志位，来判断当前是奇数层还是偶数层
                     * 进而决定是头插法还是尾插法*/
                    if (isLeft) {
                        level.offerLast(node.val);
                    } else {
                        level.offerFirst(node.val);
                    }

                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);

                }
                isLeft = !isLeft;
                result.add((List<Integer>) level);
            }
            return result;
        }

        /**
         * 方法二：使用DFS深度优先搜索，递归遍历
         * <p>
         * DFS()方法需要传入当前遍历的节点、当前层数、全局的一个result结果集
         * 遍历每层的节点时，需要根据奇数层还是偶数层，判断add()方法需要插入的位置
         *
         * @param root
         * @return
         */
        public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null)
                return result;

            DFS(root, 0, result);

            return result;
        }

        private void DFS(TreeNode node, int level, List<List<Integer>> result) {
            /*level是从0开始算的，所以当level==result.size()时，需要新开一层*/
            if (level == result.size()) {
                List<Integer> newLevel = new ArrayList<>();
                newLevel.add(node.val);
                result.add(newLevel);
            } else {
                /*取出当前层对应的用来保存节点值的列表
                 * 根据当前层数的奇偶，选择插入的索引位置*/
                if (level % 2 == 0) {
                    result.get(level).add(node.val);
                } else {
                    result.get(level).add(0, node.val);
                }
            }

            /*如果当前遍历的节点有左右孩子，就递归遍历孩子节点*/
            if (node.left != null)
                DFS(node.left, level + 1, result);
            if (node.right != null)
                DFS(node.right, level + 1, result);
        }

        /**
         * 方法三：可以不使用双端队列，仍使用 List<Integer>，需要根据奇偶层数，判断add插入时的索引位置
         *
         * @param root
         * @return
         */
        public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isLeft = true;
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();

                    /*将基础层序遍历的代码进行改造
                     * 需要根据isLeft标志位，来判断当前是奇数层还是偶数层
                     * 进而决定add方法插入元素时的索引位置
                     *
                     * 注意：奇偶性影响的不是左右孩子入队列的顺序，而是遍历当前层所有节点值入List的顺序*/
                    if (isLeft) {
                        level.add(node.val);
                    } else {
                        level.add(0, node.val);
                    }

                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);

                }
                isLeft = !isLeft;
                result.add(level);
            }
            return result;
        }
    }
}
