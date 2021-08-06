package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 找二叉树中每一行的最大值
 */
public class FindLargestValueInEachTreeRow_515 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        Solution solution = new FindLargestValueInEachTreeRow_515().new Solution();
        List<Integer> list = solution.largestValues(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    class Solution {
        public List<Integer> largestValues(TreeNode root) {

            List<Integer> res = new ArrayList<>();
            if (root == null)
                return res;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int levelMaxVal = Integer.MIN_VALUE;

            while (!queue.isEmpty()) {
                int currLevelSize = queue.size();
                for (int i = 0; i < currLevelSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.val > levelMaxVal)
                        levelMaxVal = node.val;
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                res.add(levelMaxVal);
                levelMaxVal = Integer.MIN_VALUE;
            }
            return res;
        }
    }
}
