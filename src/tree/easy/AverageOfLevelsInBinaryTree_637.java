package tree.easy;

import java.util.*;

/**
 * 计算每一层节点的平均值
 */
public class AverageOfLevelsInBinaryTree_637 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        //root.right.left = new TreeNode(15);
        //root.right.right = new TreeNode(7);

        Solution solution = new AverageOfLevelsInBinaryTree_637().new Solution();
        List<Double> averageOfLevels = solution.averageOfLevels(root);
        for (Double averageOfLevel : averageOfLevels) {
            System.out.println(averageOfLevel);
        }

    }

    class Solution {

        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        List<Double> list = new ArrayList<>();

        public List<Double> averageOfLevels(TreeNode root) {

            level(root, 0);
            for (Integer depth : levelMap.keySet()) {
                double sum = 0;
                List<Integer> temp = levelMap.get(depth);
                for (int i = 0; i < temp.size(); i++) {
                    sum += temp.get(i);
                }
                list.add(sum / temp.size());
            }
            return list;
        }

        /*最重要的是使用一个map集合保存层数，以及每一层都有哪些节点
         * key为层数
         * value为一个集合，用来存放当前层的所有节点
         * 先序遍历所有节点*/
        private void level(TreeNode root, int depth) {
            if (root == null)
                return;
            if (!levelMap.containsKey(depth)) {
                levelMap.put(depth, new ArrayList<>());
            }
            levelMap.get(depth).add(root.val);
            level(root.left, depth + 1);
            level(root.right, depth + 1);
        }

/*        List<Double> list = new ArrayList<>();
        Map<Integer, Integer> levelMap = new HashMap<>();
        int level = 0;

        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null)
                return list;
            level(root);
            Integer[] keys = levelMap.keySet().toArray(new Integer[0]);
            Integer[] values = levelMap.values().toArray(new Integer[0]);
            int maxLevel = 0;
            for (int i = 0; i < values.length; i++) {
                if (values[i] > maxLevel) {
                    maxLevel = values[i];
                }
            }

            for (int i = 0; i <= maxLevel; i++) {
                int count = 0;
                double sum = 0;
                for (int j = 0; j < keys.length; j++) {
                    if (levelMap.get(keys[j]) == i) {
                        count++;
                        sum += keys[j];
                    }
                }
                list.add((sum/count));
            }

            return list;

        }

        public void level(TreeNode root) {
            if (root == null)
                return;
            levelMap.put(root.val, level);
            if (root.left != null) {
                level++;
                level(root.left);
                level--;
            }
            if (root.right != null) {
                level++;
                level(root.right);
                level--;
            }
        }*/
    }
}
