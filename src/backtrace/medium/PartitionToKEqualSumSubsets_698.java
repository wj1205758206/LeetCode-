package backtrace.medium;

/**
 * 划分为k个相等的子集
 */
public class PartitionToKEqualSumSubsets_698 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};

        Solution solution = new PartitionToKEqualSumSubsets_698().new Solution();
        System.out.println(solution.canPartitionKSubsets3(nums, 4));
    }

    class Solution {
        /**
         * 方法一：回溯，暴力穷举，以数字的角度出发，选择桶
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean canPartitionKSubsets(int[] nums, int k) {

            //如果子集个数k都大于nums元素个数了，那么就没分平均分配，直接返回false
            if (k > nums.length)
                return false;

            //判断一下nums所有元素之和是否能整除k，整除才能平均分配
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0)
                return false;

            //定义k个子集，也就是k个桶，以及平均分配的的目标和
            int[] bucket = new int[k];
            int target = sum / k;

            /*回溯
             * nums、index这两个参数组合，相当于提供了 路径
             * bucket相当于 选择列表
             * target相当于额外的判断条件*/
            return backtrace(nums, 0, bucket, target);
        }

        private boolean backtrace(int[] nums, int index, int[] bucket, int target) {

            /*触发结束条件
             *当遍历分配完所有nums中的元素，看看每个桶里面元素和是否都是目标值*/
            if (index == nums.length) {
                for (int i = 0; i < bucket.length; i++) {
                    if (bucket[i] != target)
                        return false;
                }
                return true;
            }

            /*从选择列表中作出选择
             *这里桶就是选择列表，选择把当前nums中的元素放入哪个桶*/
            for (int i = 0; i < bucket.length; i++) {

                //剪枝操作，如果这个桶加入当前元素就超出了平均值，则排除掉当前选择，继续下一个选择
                if (bucket[i] + nums[index] > target)
                    continue;

                //作出选择，把当前元素放入选择的桶里面
                bucket[i] += nums[index];

                //继续下一层的回溯
                if (backtrace(nums, index + 1, bucket, target))
                    return true;

                //撤销选择
                bucket[i] -= nums[index];
            }

            //如果for循环做完所有选择还没有返回，说明当前元素放入哪个桶都不合适
            return false;
        }

        /**
         * 方法二：先将nums进行降序，这样能够先操作大的元素，尽可能触发剪枝操作，减少回溯次数
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean canPartitionKSubsets2(int[] nums, int k) {

            //如果子集个数k都大于nums元素个数了，那么就没分平均分配，直接返回false
            if (k > nums.length)
                return false;

            //判断一下nums所有元素之和是否能整除k，整除才能平均分配
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0)
                return false;

            //定义k个子集，也就是k个桶，以及平均分配的的目标和
            int[] bucket = new int[k];
            int target = sum / k;

            //降序操作
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[max] < nums[i]) {
                    int temp = nums[max];
                    nums[max] = nums[i];
                    nums[i] = temp;
                    max = i;
                }
            }

            /*回溯
             * nums、index这两个参数组合，相当于提供了 路径
             * bucket相当于 选择列表
             * target相当于额外的判断条件*/
            return backtrace(nums, 0, bucket, target);
        }

        /**
         * 方法三：回溯，暴力穷举，以桶的角度出发，选择数字
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean canPartitionKSubsets3(int[] nums, int k) {
            //如果子集个数k都大于nums元素个数了，那么就没分平均分配，直接返回false
            if (k > nums.length)
                return false;

            //判断一下nums所有元素之和是否能整除k，整除才能平均分配
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0)
                return false;

            //定义每个桶的平均值
            int target = sum / k;

            //降序操作,尽可能先操作较大的元素，尽可能触发剪枝操作，减少回溯
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[max] < nums[i]) {
                    int temp = nums[max];
                    nums[max] = nums[i];
                    nums[i] = temp;
                    max = i;
                }
            }

            //以桶的角度出发，需要记录数字被使用的情况
            boolean[] used = new boolean[nums.length];

            /*回溯
             * 这里从桶的角度出发，k号桶相当于了 路径
             * nums集合里面的剩余元素相当于 选择列表
             * 其它是额外的判断条件*/
            return backtrace2(k, 0, nums, 0, used, target);
        }

        private boolean backtrace2(int k, int bucketSum, int[] nums, int start, boolean[] used, int target) {

            //k等于0，说明所有桶都被装满了，而且 nums 一定全部用完了
            if (k == 0)
                return true;

            //装满了当前桶，递归穷举下一个桶的选择，让下一个桶从 nums[0] 开始选数字
            if (bucketSum == target)
                return backtrace2(k - 1, 0, nums, 0, used, target);

            /*从 start 开始向后探查有效的 nums[i] 装入当前桶
             * 因为选过的元素不能重复选择，
             * 不像是从数字角度出发选择桶，在桶没有满之前，每个元素可以选择同一个桶加入*/
            for (int i = start; i < nums.length; i++) {

                //剪枝
                if (used[i])
                    continue;
                if (nums[i] + bucketSum > target)
                    continue;

                //做出选择
                used[i] = true;
                bucketSum += nums[i];

                //继续下一层的回溯，当前桶选择剩余元素
                if (backtrace2(k, bucketSum, nums, i + 1, used, target))
                    return true;

                //撤销选择
                used[i] = false;
                bucketSum -= nums[i];
            }

            //for循环遍历完还没有返回，说明当前桶选择哪一个元素放入都不行
            return false;
        }
    }
}
