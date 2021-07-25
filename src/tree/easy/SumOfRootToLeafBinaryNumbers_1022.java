package tree.easy;

import java.util.ArrayList;
import java.util.List;


public class SumOfRootToLeafBinaryNumbers_1022 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        Solution solution = new SumOfRootToLeafBinaryNumbers_1022().new Solution();
        System.out.println(solution.sumRootToLeaf2(root));

    }

    class Solution {
        /**
         * 方法一：
         * 首先获取每一个叶子节点路径拼接成的二进制字符串，并保存在集合list中
         * 遍历list集合中每一个字符串，并把二进制字符串转成整数
         * 累加所有的整数求sum，并返回sum
         */
        List<String> list = new ArrayList<>();

        public int sumRootToLeaf(TreeNode root) {
            getPaths(root, root.val + "");
            int sum = 0;
            for (String s : list) {
                sum += biStrToInt(s);
            }
            return sum;
        }

        private int biStrToInt(String s) {

            int toInt = 0;
            int mi = 1;
            for (int i = s.length() - 1; i >= 0; i--) {

                toInt = toInt + Integer.parseInt(String.valueOf(s.charAt(i))) * mi;
                mi *= 2;
            }
            System.out.println(toInt);
            return toInt;
        }

        private void getPaths(TreeNode root, String path) {
            if (root == null)
                return;
            if (root.left == null && root.right == null) {
                list.add(path);
                return;
            }

            if (root.left != null)
                getPaths(root.left, path + root.left.val);
            if (root.right != null)
                getPaths(root.right, path + root.right.val);
        }

        /**
         * 方法二：
         * 没必要先保存每一个叶子节点的二进制字符串，在递归遍历的时候沿着路径可直接计算二进制转整数的结果
         */
        public int sumRootToLeaf2(TreeNode root) {

            return search(root, 0);
        }

        private int search(TreeNode root, int sum) {
            /*基准条件*/
            if (root == null)
                return 0;

            /*从root节点出发，沿着路径每当拼接上下一个节点值时，上次的旧值sum相当于左移一位，再加上末位的当前新的节点的值
             * sum*2 或者 sum<<1 表示左移一位，然后再加上当前新的节点的值root.val
             * 这样沿着路径不停迭代计算*/
            sum = sum * 2 + root.val;

            /*当遇到叶子节点时，sum也就计算出当前叶子节点的十进制结果*/
            if (root.left == null && root.right == null)
                return sum;

            /*递归计算左子树和右子树中所有叶子节点的值*/
            return search(root.left, sum) + search(root.right, sum);
        }
    }
}
