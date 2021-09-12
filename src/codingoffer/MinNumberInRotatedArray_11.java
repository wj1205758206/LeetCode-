package codingoffer;

/**
 * 旋转数组的最小数字
 */
public class MinNumberInRotatedArray_11 {
    public static void main(String[] args) {
        Solution solution = new MinNumberInRotatedArray_11().new Solution();
        System.out.println(solution.minArray(new int[]{1}));
    }

    class Solution {
        /**
         * 采用二分查找，旋转后的数组相当于被划分成了两个递增子数组
         *
         * @param numbers
         * @return
         */
        public int minArray(int[] numbers) {
            //如果数组为空，直接返回-1表示异常
            if (numbers.length == 0) return -1;
            //如果数组只有一个元素，也就没必要找了，直接返回这一个元素即可
            if (numbers.length == 1) return numbers[0];

            /*当数组元素大于等于2时，也有找的必要*/
            int low = 0;
            int high = numbers.length - 1;

            /*我们要考虑的第一种情况：
             * 如果旋转完之后还是数组本身，也就是旋转了0个元素，那么整体数组是一个递增数组，直接返回第一个元素即可*/
            if (numbers[low] < numbers[high])
                return numbers[low];

            while (low < high) {

                /*
                 * 当low和high相邻了，那么high指向的就是那个最小元素，直接返回*/
                if (low + 1 == high)
                    return numbers[high];

                /*找到数组的中间位置*/
                int midIndex = (low + high) / 2;

                /*我们要考虑的第二种情况：
                 * 原始数组被旋转后划分为两个递增的子数组，如果说low、high、minIndex三个元素相等了
                 *那么我们是没办法再继续使用二分查找的，因为没有办法判断中间这个元素到底是属于第一个子数组，还是属于第二个子数组
                 * 此时，我们只能按照顺序查找*/
                if (numbers[low] == numbers[midIndex] && numbers[midIndex] == numbers[high])
                    return orderFind(numbers, low, high);

                /*我们要考虑的第三种情况：
                 * 如果中间元素大于等于low指向的元素，那么这个中间元素一定是属于第一个子数组的
                 * 那么最小元素一定在minIndex后面，所以low指向minIndex，缩小low和high之间的距离
                 *
                 * 如果中间元素小于等于high指向的元素，那么这个中间元素一定是属于第二个子数组的
                 * 那么最小元素一定在minIndex前面，所以high指向minIndex，缩小low和high之间的距离*/
                if (numbers[midIndex] >= numbers[low])
                    low = midIndex;
                else if (numbers[midIndex] <= numbers[high])
                    high = midIndex;
            }
            return -1;
        }

        private int orderFind(int[] numbers, int low, int high) {
            /*顺序查找，low和high本事都可能是最小值，区间是[low,high]
             *所以假设第一个元素low就是最小值*/
            int res = numbers[low];

            /*从第二个元素开始比较，high本事能取到值*/
            for (int i = low + 1; i <= high; i++) {
                if (res > numbers[i]) {
                    res = numbers[i];
                }
            }
            return res;
        }
    }
}
