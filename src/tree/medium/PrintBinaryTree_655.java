package tree.medium;

import java.util.*;

/**
 * 输出二叉树到二维数组
 */
public class PrintBinaryTree_655 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 方法一：DFS深度优先搜索
         *
         * @param root
         * @return
         */
        public List<List<String>> printTree(TreeNode root) {
            int m = maxDepth(root);//计算二叉树的高度
            String[][] result = new String[m][(1 << m) - 1];//根据计算出的高度，可求出二维数组的行数m和列数2的m次方-1
            for (String[] level : result) {
                Arrays.fill(level, "");//先将二维数组全部填充为 ""
            }
            List<List<String>> ans = new ArrayList<>();

            /*构造辅助函数，深度遍历每一个节点，不断填充二维数组*/
            fill(result, root, 0, 0, result[0].length);

            for (String[] level : result) {
                ans.add(Arrays.asList(level));
            }

            return ans;
        }

        /**
         * 构造填充辅助函数
         *
         * @param result 待填充的二维数组
         * @param root   当前递归遍历到的节点
         * @param i      当前层数
         * @param left   以当前节点为root的子树的左边界
         * @param right  以当前节点为root的子树的右边界
         */
        private void fill(String[][] result, TreeNode root, int i, int left, int right) {
            if (root == null)
                return;

            /*每次递归遍历需要确定的是当前root节点在二维数组中的位置
             * 行：即为层数i
             * 列：为当前子树的左右边界的中间位置*/
            result[i][(left + right) / 2] = "" + root.val;

            /*递归遍历左子树，层数加1，左边界不变，右边界变为上次遍历的中间位置*/
            fill(result, root.left, i + 1, left, (left + right) / 2);

            /*递归遍历右子树，层数加1，左边界变为上次遍历中间位置的下一位置，右边界不变*/
            fill(result, root.right, i + 1, (left + right + 1) / 2, right);
        }

        private int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        /**
         * 方法二：BFS广度优先搜索
         */
        class Location {
            /*和方法一差不多，只不过将构造辅助函数的参数抽取出一个类
             * 这个类描述了当前递归遍历的root节点，层数，以及这棵子树的左右边界*/
            TreeNode root;
            int i, left, right;

            Location(TreeNode node, int i, int left, int right) {
                this.root = node;
                this.i = i;
                this.left = left;
                this.right = right;
            }
        }

        public List<List<String>> printTree2(TreeNode root) {
            int m = maxDepth(root);
            String[][] result = new String[m][(1 << m) - 1];
            for (String[] level : result) {
                Arrays.fill(level, "");
            }
            List<List<String>> ans = new ArrayList<>();
            fill2(result, root, 0, 0, result[0].length);
            for (String[] level : result) {
                ans.add(Arrays.asList(level));
            }
            return ans;
        }

        private void fill2(String[][] result, TreeNode root, int i, int left, int right) {
            Queue<Location> queue = new LinkedList<>();
            queue.offer(new Location(root, 0, 0, result[0].length));

            while (!queue.isEmpty()) {
                Location location = queue.poll();
                result[location.i][(location.left + location.right) / 2] = "" + location.root.val;
                if (location.root.left != null)
                    queue.offer(
                            new Location(location.root.left, location.i + 1,
                                    location.left, (location.left + location.right) / 2));
                if (location.root.right != null)
                    queue.offer(
                            new Location(location.root.right, location.i + 1,
                                    (location.left + location.right + 1) / 2, location.right));
            }
        }
    }

}
