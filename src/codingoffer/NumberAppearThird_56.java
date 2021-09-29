package codingoffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组中数字出现的次数(3次中找出现1的数字)
 */
public class NumberAppearThird_56 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 位运算
         *
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            int[] count = new int[32];

            //将每一个元素拆分为32bit，分别保存在位数组中
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < count.length; j++) {
                    //累加每个元素的每一位
                    count[j] += nums[i] & 1;
                    nums[i] >>>= 1;
                }
            }

            int res = 0;
            for (int i = 0; i < count.length; i++) {
                res <<= 1;
                //对3取余，相当于消除了3的倍数，剩下的就是只出现一次的那个数对应的位的值
                //并且使用或运算，从高位不断恢复原来的数字
                //对3取余，3可以改为其他数字，题目就变成其它数字出现m次
                res |= count[31 - i] % 3;
            }
            return res;
        }

        /**
         * 哈希表统计
         *
         * @param nums
         * @return
         */
        public int singleNumber2(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    int times = map.get(num);
                    map.put(num, times + 1);
                } else {
                    map.put(num, 1);
                }
            }
            int res = 0;
            Set<Integer> set = map.keySet();
            for (Integer k : set) {
                if (map.get(k) == 1)
                    res = k;
            }
            return res;
        }

    }
}
