package greedy.medium;

/**
 * 跳跃游戏
 */
public class JumpGame_55 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 贪心算法
         *
         * @param nums
         * @return
         */
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int forthest = 0;

            /*不断计算从当前索引为i的位置，最多能跳多远，计算局部最优解，最后可以找到全局最优解*/
            for (int i = 0; i < n - 1; i++) {
                forthest = Math.max(forthest, i + nums[i]);
                /*如果说从当前位置forthest没有改变，小于或者等于i，说明跳不动了，nums[i]的值为0
                 * 因此也就跳不到最后一个元素了*/
                if (forthest <= i)
                    return false;
            }
            /*如果可以最远跳出最后一个元素，则返回true*/
            return forthest >= n - 1;
        }
    }
}
