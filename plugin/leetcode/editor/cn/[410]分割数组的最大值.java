
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int m) {
        int left = getMax(nums);
        int right = getSUm(nums);

//        for (int max = left; max <= right; max++) {
//            int n = split(nums, max);
//            if (n <= m) {
//                return max;
//            }
//        }
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            int n = split(nums, mid);
//            if (n == m) {
//                right = mid - 1;
//            } else if (n < m) {
//                right = mid - 1;
//            } else if (n > m) {
//                left = mid + 1;
//            }
//        }
        while (left < right) {
            int mid = (left + right) / 2;
            int n = split(nums, mid);
            if (n == m) {
                right = mid;
            } else if (n < m) {
                right = mid;
            } else if (n > m) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int split(int[] nums, int max) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > max) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return count;
    }

    public int getMax(int[] nums) {
        int res = -1;
        for (int num : nums) {
            res = Math.max(res, num);
        }
        return res;
    }

    public int getSUm(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
