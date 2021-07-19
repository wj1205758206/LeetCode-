package tree.easy;

import java.util.*;

/**
 * 找出BST中出现次数最多的节点
 */
public class FindModeInBST_501 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        Solution solution = new FindModeInBST_501().new Solution();
        int[] mode = solution.findMode(root);
        for (int i : mode) {
            System.out.println(i);
        }

    }

    class Solution {

        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 1;


        public int[] findMode(TreeNode root) {

            valCount(root);

            int[] modes = new int[map.size()];
            int length = 0;

            /*map保存每一个节点值出现的次数
             * 遍历map，找出等于maxCount的key*/
            for (Integer key : map.keySet()) {
                if (map.get(key) == maxCount) {
                    modes[length++] = key;
                }
            }

            return Arrays.copyOf(modes, length);
        }

        /*先序遍历所有节点
         * 使用Map保存每一个节点出现的次数，key是节点值 value是该节点出现的次数
         * */
        private void valCount(TreeNode root) {
            if (root == null)
                return;
            /*如果节点之前保存过，就更新次数+1，如果节点之前没有保存过，就直接put，次数为1*/
            if (map.containsKey(root.val)) {
                Integer count = map.get(root.val) + 1;
                map.put(root.val, count);
                //维护一个maxCount变量，用来保存每次更新次数时，记录次数的最大值
                maxCount = Math.max(maxCount, count);
            } else {
                map.put(root.val, 1);
            }
            /*递归遍历左右子树*/
            valCount(root.left);
            valCount(root.right);
        }

    }
}
