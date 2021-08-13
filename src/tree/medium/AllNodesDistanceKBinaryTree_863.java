package tree.medium;

import java.util.*;

/**
 * 二叉树中所有距离为 K 的结点
 */
public class AllNodesDistanceKBinaryTree_863 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Solution solution = new AllNodesDistanceKBinaryTree_863().new Solution();
        List<Integer> list = solution.distanceK(root, root.left, 2);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    class Solution {
        /**
         * DFS深度优先搜索+哈希表
         * 哈希表用来保存每一个节点的父节点，用于向上搜索
         */
        List<Integer> result = new ArrayList<>();
        Map<Integer, TreeNode> map = new HashMap<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            findParent(root);//先序遍历，递归保存每一个节点的父节点
            findResult(target, null, 0, k);//以目标值为起点，DFS搜索距离为k的所有节点

            return result;
        }

        private void findResult(TreeNode root, TreeNode from, int depth, int k) {
            if (root == null)
                return;
            if (depth == k) {
                result.add(root.val);
                return;
            }

            /*向下搜索左右子树，需要判断是否来自源节点，因为有可能父节点向下搜索时重复访问节点*/
            if (root.left != from) {
                findResult(root.left, root, depth + 1, k);
            }
            if (root.right != from) {
                findResult(root.right, root, depth + 1, k);
            }

            /*除了向下搜索还需要向上搜索，同样也需要判断是否来自源节点，因为有可能左右子树向上搜索时重复访问源节点
             * 由于每一个节点建立了父节点索引，所以整个树变成了有向图！任意两个节点相互连通，所以需要判断是否来自源节点*/
            if (map.get(root.val) != from) {
                findResult(map.get(root.val), root, depth + 1, k);
            }
        }

        private void findParent(TreeNode root) {
            if (root == null)
                return;
            if (root.left != null) {
                map.put(root.left.val, root);
            }
            if (root.right != null) {
                map.put(root.right.val, root);
            }
            findParent(root.left);
            findParent(root.right);
        }
    }
}
