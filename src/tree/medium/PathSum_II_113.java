package tree.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算二叉树中路径和等于目标值的所有路径
 */
public class PathSum_II_113 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Solution solution = new PathSum_II_113().new Solution();
        List<List<Integer>> lists = solution.pathSum(root, 22);
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.println("]");
        }

    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {


            if (root == null)
                return result;

            DFS(root, targetSum);

            return result;
        }

        private void DFS(TreeNode root, int targetSum) {
            path.add(root.val);
            targetSum -= root.val;
            if (root.left == null && root.right == null && targetSum == 0) {
                result.add(new ArrayList<>(path));
            }
            if (root.left != null)
                DFS(root.left, targetSum);
            if (root.right != null)
                DFS(root.right, targetSum);
            path.remove(path.size() - 1);

        }
    }

}
