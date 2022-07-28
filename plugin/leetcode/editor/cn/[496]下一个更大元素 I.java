
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = nextGreaterElement(nums2);
        Map<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < greater.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] greater = new int[n];
        Stack<Integer> stack = new Stack<>();
        //倒着遍历
        for (int i = n - 1; i >= 0; i--) {
            //把栈内所有小于当前元素的都pop出来
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            greater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return greater;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
