package tree.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 找出二叉树中第二小的节点
 */
public class SecondMinNodeInBinaryTree_671 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        Solution solution = new SecondMinNodeInBinaryTree_671().new Solution();
        System.out.println(solution.findSecondMinimumValue(root));

    }

    /*先序遍历保存所有节点值
     * 使用sort方法给list排序
     * 遍历已排序的list，找到第二小的节点值并返回*/
    class Solution {
        List<Integer> list = new ArrayList<>();

        public int findSecondMinimumValue(TreeNode root) {
            preOrder(root);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > list.get(0))
                    return list.get(i);
            }
            return -1;
        }

        private void preOrder(TreeNode root) {
            if (root == null)
                return;
            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
