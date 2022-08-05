
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] missingTwo(int[] nums) {
        int[] arr = new int[nums.length + 3];
        for (int num : nums){
            arr[num] = num;
        }
        int index = 0;
        int[] res = new int[2];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0){
                res[index++] = i;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
