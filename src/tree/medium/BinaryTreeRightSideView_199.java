package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 */
public class BinaryTreeRightSideView_199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        //root.right.right = new TreeNode(4);

        Solution solution = new BinaryTreeRightSideView_199().new Solution();
        List<Integer> list = solution.rightSideView2(root);
        for (Integer val : list) {
            System.out.println(val);
        }
    }

    class Solution {
        /**
         * 方法一：DFS深度优先搜索
         */
        private List<Integer> list = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {

            /*深度优先搜索，扩展参数列表，维护当前递归深depth深度信息*/
            DFS(root, 0);
            return list;
        }

        private void DFS(TreeNode root, int depth) {
            if (root == null)
                return;

            /*如果当前深度等于集合的大小，则说明当前遍历的节点是该深度下第一个被访问的节点
             * 否则在递归回退遍历其它节点时这个深度的应该小于集合的大小*/
            if (depth == list.size())
                list.add(root.val);

            /*先递归遍历右子树，在递归遍历左子树
             * 这样就能够保证右侧节点先被遍历到*/
            depth++;
            DFS(root.right, depth);
            DFS(root.left, depth);
        }

        /**
         * 方法二：BFS广度优先搜索，每次只保存当前层的最右侧的节点
         *
         * @param root
         * @return
         */
        public List<Integer> rightSideView2(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();
                    /*每次只保存当前层的最右侧的节点*/
                    if (i == currentLevelSize - 1)
                        result.add(node.val);
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
            }
            return result;
        }
    }
}
