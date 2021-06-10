package array.easy;

/**
 * 移除数组中指定的元素
 */
public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,5,3,3,7};
        Solution solution = new Solution();
        int len = solution.removeElement(nums, 3);
        System.out.println(len);
        for (int num : nums) {
            System.out.print(num);
        }

    }
    static class Solution {
        /**
         * 使用快慢双指针，移除指定的元素
         * @param nums  传入的数组
         * @param val   需要移除的目标值
         * @return      返回移除指定元素后的数组长度
         */
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0)
                return 0;
            int slow, fast;
            slow = fast = 0;
            while (fast < nums.length) {
                /*未找到第一个指定元素时，快慢指针会同时向后移动
                * 定位到第一个需要移除的元素时，slow不再移动，只移动fast，让fast移动到不是非移除元素的位置
                * 然后将fast指向的元素覆盖slow指向的需要移除的元素，相当于把指定的元素移除掉，后面的元素向前移
                * */
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            /*长度是索引+1，slow循环完刚好是代表的元素个数*/
            return slow;
        }
    }
}
