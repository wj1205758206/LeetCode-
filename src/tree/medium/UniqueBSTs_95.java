package tree.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 构造不同的二叉搜索树
 */
public class UniqueBSTs_95 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> generateTrees = solution.generateTrees(3);
        Iterator<TreeNode> iterator = generateTrees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().val);
        }
    }

    static class Solution {
        /**
         * 构造不同的BST，和第96题差不多，要想构造出不同的BST首先要计算出可以构成多少棵不同的BST
         * 通过辅助函数build扩展参数列表，递归构造出不同区间的二叉树
         *
         * @param n 二叉树的节点个数
         * @return 返回存储着构造出来的不同BST根节点的列表
         */
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new LinkedList<>();
            return build(1, n);
        }

        /**
         * 辅助函数，通过扩展参数列表，构造出不同区间的BST
         *
         * @param low  闭区间左边界
         * @param high 闭区间右边界
         * @return 返回存储着构造出来的不同BST根节点的列表
         */
        public List<TreeNode> build(int low, int high) {
            List<TreeNode> listBST = new LinkedList<>();

            /*基准条件
             * 最底层空节点也算一个节点，返回null*/
            if (low > high) {
                listBST.add(null);
                return listBST;
            }

            /*穷举区间[low,high]内所有可以冲root根节点的可能*/
            for (int i = low; i <= high; i++) {

                /*递归构造出左右子树所有的BST*/
                List<TreeNode> leftTree = build(low, i - 1);
                List<TreeNode> rightTree = build(i + 1, high);

                /*双重循环，穷举root节点左右子树的所有组合的可能*/
                for (TreeNode left : leftTree) {
                    for (TreeNode right : rightTree) {
                        TreeNode root = new TreeNode(i);    //构造root根节点
                        root.left = left;                   //构造root根节点左孩子
                        root.right = right;                 //构造root根节点右孩子
                        listBST.add(root);                  //将构造出来的这棵BST的根节点添加到列表中
                    }
                }
            }
            return listBST;
        }
    }
}
