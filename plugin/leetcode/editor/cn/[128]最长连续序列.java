
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        //定义一个哈希表hash，将nums数组中的数都放入哈希表中,去重
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int x : set) {
            //遍历哈希表hash，如果当前数x的前驱x-1不存在，我们就以当前数x为起点向后枚举
            if (!set.contains(x - 1)) {
                int y = x;
                while (set.contains(y + 1)) y++;
                //假设最长枚举到了数y，那么连续序列长度即为y-x+1
                //不断枚举更新答案
                result = Math.max(result, y - x + 1);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
