package tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断BST中是否存在两个节点值之和等于目标值
 */
public class TwoSum_IV_Input_BST_653 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution solution = new TwoSum_IV_Input_BST_653().new Solution();
        boolean target = solution.findTarget(root, 4);
        System.out.println(target);

    }

    class Solution {
        List<Integer> list = new ArrayList<>();

        /*利用BST中序遍历升序的性质
         * 在升序集合中使用双指针，从左右端依次向中间遍历，判断是否存在两个值之和等于目标值*/
        public boolean findTarget(TreeNode root, int k) {
            inOrder(root);
            int i = 0;
            int j = list.size() - 1;
            while (i < j) {
                if (list.get(i) + list.get(j) == k) {
                    return true;
                }
                if (list.get(i) + list.get(j) > k) {
                    j--;
                } else if (list.get(i) + list.get(j) < k) {
                    i++;
                }
            }
            return false;

        }

        private void inOrder(TreeNode root) {
            if (root == null)
                return;
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }
}
