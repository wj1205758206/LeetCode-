package codingoffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNumber_39 {
    public static void main(String[] args) {
        Solution solution = new MoreThanHalfNumber_39().new Solution();
        System.out.println(solution.majorityElement2(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }

        public int majorityElement2(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    Integer count = map.get(num);
                    map.put(num, count + 1);
                } else {
                    map.put(num, 1);
                }
            }
            Set<Integer> set = map.keySet();
            int res = -1;
            int max = -1;
            for (Integer k : set) {
                if (map.get(k) > max) {
                    max = map.get(k);
                    res = k;
                }
            }
            return res;
        }

        public int majorityElement3(int[] nums) {
            if (nums.length == 0)
                return -1;
            int result = nums[0];
            int times = 1;
            for (int i = 1; i < nums.length; i++) {
                if (times == 0) {   //当出现次数减为0的时候，说明当前result记录的元素出现的次数并不是最多的，所以result更新为下一个元素，再继续比较
                    result = nums[i];
                    times = 1;
                } else if (nums[i] == result) {
                    times++;//遍历到一样的，出现次数就加1
                } else {
                    times--;//遍历到不一样的，出现次数就减1
                }
            }
            return result;
        }
    }

}
