
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        //候选者数量
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            //当count==0时，说明还没有找到过半的那个数，此时将当前的num作为候选者
            if (count == 0) {
                candidate = num;
            }
            //遍历过程中不断比较num是否与候选者相同，相同则加一，不同减一
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
