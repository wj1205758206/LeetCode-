package backtrace.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 构造不同的BST
 */
public class UniqueBST_II_95 {
    public static void main(String[] args) {
        Solution solution = new UniqueBST_II_95().new Solution();
        System.out.println(solution.generateTrees(3));
    }

    class Solution {


        public List<TreeNode> generateTrees(int n) {
            if (n == 0)
                return new ArrayList<>();

            return DFS(1, n);

        }

        private List<TreeNode> DFS(int left, int right) {
            List<TreeNode> result = new ArrayList<>();

            if (left > right) {
                result.add(null);
                return result;
            }

            for (int i = left; i <= right; i++) {
                List<TreeNode> leftTree = DFS(left, i - 1);
                List<TreeNode> rightTrees = DFS(i + 1, right);

                for (TreeNode leftT : leftTree) {
                    for (TreeNode rightT : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftT;
                        root.right = rightT;
                        result.add(root);
                    }
                }
            }
            return result;
        }


        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    }
}