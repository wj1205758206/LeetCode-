package tree.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有可能的满二叉树
 */
public class AllPossibleFullBinaryTrees_894 {
    public static void main(String[] args) {
        Solution solution = new AllPossibleFullBinaryTrees_894().new Solution();
        System.out.println(solution.allPossibleFBT2(7).size());
    }

    class Solution {

        /**
         * 方法一：利用递归定义求解，切勿陷入如何逐个改造左右子树的大坑！！！ 要利用函数的递归定义！递归思想！！！
         * 这里定义的函数，其含义就是给定节点个数，返回能构造出的满二叉树的所有根节点集合！！！
         *
         * @param n
         * @return
         */
        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> result = new ArrayList<>();

            /*如果给定的节点为1，那么直接返回一个root节点的集合即可
             * 另外偶数个是不能构造出题目所规定的满二叉树定义的，只能是奇数个节点*/
            if (n == 1) {
                result.add(new TreeNode(0));
                return result;
            }

            /*从这个循环开始就要利用递归思想了！！！切勿去思考如何挨个构造左右子树！！！
             * 首先要明白题目规定一个节点，要么有0个孩子节点，要么有2个孩子节点
             * 我们要想求n个节点能构造出多少种满二叉树，只需要只能n-1个节点能构造出多少种左右子树的排列组合就可以了
             * i初始值为1，因为节点的孩子要么有0个孩子节点，要么有2个孩子节点，所以至少预留出一个节点给另一颗子树
             * 所以 i < n-1，i的步长为2
             * 外层循环是不断分配给定左右子树不同的节点个数
             *
             * */
            for (int i = 1; i < n - 1; i += 2) {

                /*这里两个是利用递归定义求解的左右子树所能构成的满足条件的根节点集合！！！
                 * 我不没有手动去求解在给定的i个数，所能构造出多少种树
                 * 而是利用函数，函数定义就是返回满足条件的根节点集合！！！可以认为函数已经自动帮你计算好了！！！*/
                List<TreeNode> leftTrees = allPossibleFBT(i);
                List<TreeNode> rightTrees = allPossibleFBT(n - 1 - i);

                /*接下来就是利用左右子树的根节点集合做排列组合，使用双重循环
                 * 这个双重循环是计算外层循环给定好的左右子树节点个数的排列组合有多少*/
                for (int j = 0; j < leftTrees.size(); j++) {
                    for (int k = 0; k < rightTrees.size(); k++) {
                        /*从左子树选取一种，从右子树选取一种，就可能构造出一颗满二叉树！！！*/
                        TreeNode root = new TreeNode(0);
                        root.left = leftTrees.get(j);
                        root.right = rightTrees.get(k);
                        /*将这一种满二叉树的root节点存储到结果集中*/
                        result.add(root);
                    }
                }
            }

            /*外层循环结束，也就计算出了所有的满二叉树可能性*/
            return result;
        }

        /**
         * 方法二：很明显方法一有重复计算！！！利用哈希表记忆表，做缓存减少计算
         */
        Map<Integer, List<TreeNode>> memory = new HashMap<>();

        public List<TreeNode> allPossibleFBT2(int n) {
            List<TreeNode> list = new ArrayList<>();
            if (n == 1) {
                list.add(new TreeNode(0));
                return list;
            }

            for (int i = 1; i < n - 1; i += 2) {

                /*比如分配左子树3节点所能构成节点集合，分配给右子树5个节点所能构成的节点集合
                 * 与 分配右子树3节点所能构成节点集合，分配给左子树3个节点所能构成的节点集合 相比！
                 * 这里存在重复计算！因为关心的是给定的节点个数对应的是能成满足条件的根节点集合
                 * 而不关心是左子树是3个节点还是右子树3个节点
                 * 所以使用哈希表做缓存*/
                List<TreeNode> leftTrees;
                List<TreeNode> rightTrees;
                if (memory.containsKey(i)) {
                    leftTrees = memory.get(i);
                } else {
                    leftTrees = allPossibleFBT2(i);
                }
                if (memory.containsKey(n - 1 - i)) {
                    rightTrees = allPossibleFBT2(n - 1 - i);
                } else {
                    rightTrees = allPossibleFBT2(n - 1 - i);
                }

                for (int j = 0; j < leftTrees.size(); j++) {
                    for (int k = 0; k < rightTrees.size(); k++) {
                        TreeNode root = new TreeNode(0);
                        root.left = leftTrees.get(j);
                        root.right = rightTrees.get(k);
                        list.add(root);
                    }
                }
            }
            memory.put(n, list);
            return list;
        }
    }
}
