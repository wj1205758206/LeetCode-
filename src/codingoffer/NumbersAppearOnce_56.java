package codingoffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组中数字出现的次数(位运算)
 */
public class NumbersAppearOnce_56 {
    public static void main(String[] args) {
        Solution solution = new NumbersAppearOnce_56().new Solution();
        int[] res = solution.singleNumbers2(new int[]{4, 1, 4, 6});
        for (int num : res) {
            System.out.println(num);
        }
    }

    class Solution {
        /**
         * 哈希表统计次数
         *
         * @param nums
         * @return
         */
        public int[] singleNumbers(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    int times = map.get(nums[i]);
                    map.put(nums[i], times + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            int[] res = new int[2];
            int index = 0;
            Set<Integer> set = map.keySet();
            for (Integer k : set) {
                if (map.get(k) == 1)
                    res[index++] = k;
            }
            return res;
        }

        /**
         * 位运算
         *
         * @param nums
         * @return
         */
        public int[] singleNumbers2(int[] nums) {
            if (nums.length == 0) return new int[0];
            int x = 0, y = 0, n = 0, m = 1;
            //将所有元素进行异或元素，成对出现的元素将会为0，最后只会n = x 异或 y
            for (int num : nums) {
                n ^= num;
            }

            //我们想办法将xy分到两组里面，我们从低位开始,不断向高位找 x y 的不同位
            //(x ^ y) & m 异或为0，说明xy当前比较的位是相同的，异或为1，说明xy当前比较的位是不相同，这就是我们要找的不同位
            //找到不同位也就相当于找到了分组标准
            while ((n & m) == 0) {
                m <<= 1;
            }

            //分组遍历，不断异或
            for (int num : nums) {
                //以m为标准，此时m即为找到的不同位
                //主要是将xy分开，其它元素会成对分到其中一组，xy会分到不同组
                if ((num & m) != 0) {
                    x ^= num;
                } else {
                    y ^= num;
                }
            }
            return new int[]{x, y};
        }
    }
}
