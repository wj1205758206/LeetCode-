package tree.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计算出现次数最多的子树元素和
 */
public class MostFrequentSubtreeSum_508 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);

        Solution solution = new MostFrequentSubtreeSum_508().new Solution();
        int[] frequentTreeSum = solution.findFrequentTreeSum(root);
        for (int i : frequentTreeSum) {
            System.out.println(i);
        }

    }

    class Solution {
        /**
         * 后序遍历结合计数，来计算每个当前root节点的子树元素和
         * 使用map集合保存子树元素和与次数的映射关系
         */
        private Map<Integer, Integer> map = new HashMap<>();
        private int maxFrequent = Integer.MIN_VALUE;

        public int[] findFrequentTreeSum(TreeNode root) {
            postTreeSum(root);
            List<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxFrequent) {
                    result.add(entry.getKey());
                }
            }
            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }

            return res;
        }

        private int postTreeSum(TreeNode root) {
            if (root == null)
                return 0;
            int left = postTreeSum(root.left);  //计算左子树元素和
            int right = postTreeSum(root.right);//计算右子树元素和
            int sum = left + right + root.val;  //求当前root子树元素和(包含root)
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1); //如果计算当前root的子树元素和之前已经有过，则把次数加1
            } else {
                map.put(sum, 0);
            }
            maxFrequent = Math.max(maxFrequent, map.get(sum)); //与当前的root子树元素和出现的次数相比较，更新最大次数

            return sum;
        }
    }
}
