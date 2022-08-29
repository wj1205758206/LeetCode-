
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<Integer> mode = new ArrayList<>();
    TreeNode pre = null;
    int curCount = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] res = new int[mode.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = mode.get(i);
        }
        return res;
    }

    public void dfs(TreeNode root) {

        if (root == null) return;

        dfs(root.left);

        //中序遍历位置
        if (pre == null) {
            curCount = 1;
            maxCount = 1;
            mode.add(root.val);
        } else {
            if (root.val == pre.val) {
                curCount++;
                if (curCount == maxCount) {
                    mode.add(root.val);
                } else if (curCount > maxCount) {
                    mode.clear();
                    mode.add(root.val);
                    maxCount = curCount;
                }
            } else {
                curCount = 1;
                if (curCount == maxCount) {
                    mode.add(root.val);
                }
            }
        }

        pre = root;
        //中序遍历位置

        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
