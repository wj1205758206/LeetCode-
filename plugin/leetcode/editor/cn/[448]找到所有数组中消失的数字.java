
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num] = num;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0){
                result.add(i);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
