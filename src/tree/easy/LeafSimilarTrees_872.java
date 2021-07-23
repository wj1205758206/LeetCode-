package tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断两个树的叶子序列是否相同
 */
public class LeafSimilarTrees_872 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.left.right.left = new TreeNode(2);
        root2.right = new TreeNode(1);
        root2.right.left = new TreeNode(9);
        root2.right.right = new TreeNode(8);

        Solution solution = new LeafSimilarTrees_872().new Solution();
        System.out.println(solution.leafSimilar(root1, root2));

    }

    /*使用先序遍历遍历两棵树，分别保存叶子结点到集合中
     * 比较两个list集合元素是否完全相同*/
    class Solution {
        List<Integer> root1Leafs = new ArrayList<>();
        List<Integer> root2Leafs = new ArrayList<>();


        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            preOrder(root1, root1Leafs);
            preOrder(root2, root2Leafs);
            return root1Leafs.equals(root2Leafs);
        }

        private void preOrder(TreeNode root, List<Integer> rootleafs) {
            if (root == null)
                return;
            if (root.left == null && root.right == null)
                rootleafs.add(root.val);
            preOrder(root.left, rootleafs);
            preOrder(root.right, rootleafs);
        }
    }
}
