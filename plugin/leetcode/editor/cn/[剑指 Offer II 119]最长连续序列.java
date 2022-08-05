
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int y = x;
                while (set.contains(y+1)) y++;
                maxLen = Math.max(maxLen, y - x + 1);
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
