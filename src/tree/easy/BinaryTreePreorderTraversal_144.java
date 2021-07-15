package tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的先序遍历
 */
public class BinaryTreePreorderTraversal_144 {
    public static void main(String[] args) {

    }

    class Solution {
        List<Integer> list = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null)
                return list;
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);

            return list;
        }
    }
}
