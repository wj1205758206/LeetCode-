
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int[] arr = new int[nums.length + 1];
        Arrays.fill(arr, -1);
        for (int num : nums) {
            arr[num] = num;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
