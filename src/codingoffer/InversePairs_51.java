package codingoffer;

/**
 * 数组中的逆序对
 */
public class InversePairs_51 {
    public static void main(String[] args) {
        Solution solution = new InversePairs_51().new Solution();
        System.out.println(solution.reversePairs2(new int[]{7, 5, 6, 4}));
    }

    class Solution {
        /**
         * 暴力求解，超时
         *
         * @param nums
         * @return
         */
        public int reversePairs(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[i] > nums[j])
                        res++;
                }
            }
            return res;
        }

        /**
         * 归并排序
         */
        int count = 0;

        public int reversePairs2(int[] nums) {
            merge(nums, 0, nums.length - 1);
            return count;
        }

        private void merge(int[] nums, int left, int right) {
            //传参nums一直是原数组，所以不能使用length/2计算mid，只能通过动态的left和right计算mid
            int mid = (left + right) / 2;
            if (left < right) {
                //递归拆分左子数组
                merge(nums, left, mid);
                //递归拆分右子数组
                merge(nums, mid + 1, right);
                //排序合并
                mergeSort(nums, left, mid, right);
            }
        }

        private void mergeSort(int[] nums, int left, int mid, int right) {
            //根据left、right确定拆分的辅助数组的长度
            int[] temp = new int[right - left + 1];
            int index = 0;

            //p始终指向左子数组的第一个元素，q始终指向右子数组的第一个元素
            int p = left, q = mid + 1;

            while (p <= mid && q <= right) {
                //如果左子数组的当前元素小于等于右子数组的当前元素，直接放入辅助数组中即可
                if (nums[p] <= nums[q]) {
                    temp[index++] = nums[p++];
                } else {
                    //如果大于了右子数组当前元素，这说明产生了逆序，左子数组当前元素的剩余的右边的元素，都是大于右子数组当前元素的
                    count += (mid - p + 1);
                    temp[index++] = nums[q++];
                }
            }

            //将剩余左子数组中元素放入辅助数组中
            while (p <= mid) {
                temp[index++] = nums[p++];
            }
            //将剩余右子数组中元素放入辅助数组中
            while (q <= right) {
                temp[index++] = nums[q++];
            }
            //合并后覆盖原来的数组
            for (int i = 0; i < temp.length; i++) {
                nums[left + i] = temp[i];
            }
        }
    }
}
