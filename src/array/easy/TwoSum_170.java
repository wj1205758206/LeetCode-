package array.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 判断列表中是否存在两数之和等于目标值
 */
public class TwoSum_170 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.add(2);
        solution.add(7);
        solution.add(11);
        solution.add(15);

        System.out.println(solution.find(9));
        System.out.println(solution.find(2));

    }

    static class Solution {
        /*set集合用于存放两数之和的所有可能值*/
        Set<Integer> sum = new HashSet<>();

        /*list用于存放元素值*/
        List<Integer> nums = new ArrayList<>();

        /**
         * add方法向列表中添加元素
         * 每次添加元素的时候，都会计算添加元素与列表中每个已存在元素的和
         * 并把计算和存放在set集合中，这样set集合中保存了列表所有两数之和的可能值
         * @param number    添加的元素值
         */
        public void add(int number) {
            for (int num : nums) {
                sum.add(num + number);
            }
            nums.add(number);
        }

        /**
         * find方法只需要判断set集合中是否存在与目标值相等的值即可，时间复杂度为 O(1)
         * @param value  传入的目标值
         * @return
         */
        public boolean find(int value) {
            return sum.contains(value);
        }
    }
}
