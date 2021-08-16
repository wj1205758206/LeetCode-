package backtrace.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 */
public class Subsets_78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Solution solution = new Subsets_78().new Solution();
        System.out.println(solution.subsets2(nums));
    }

    class Solution {
        /**
         * 方法一：DFS深度优先搜索，递归求解子集，然后追加
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets(int[] nums) {

            /*基准条件
             * 空集是创建一个空集合*/
            if (nums.length == 0) {
                List<List<Integer>> res = new ArrayList<>();
                res.add(new ArrayList<>());
                return res;
            }

            int lastNum = nums[nums.length - 1];

            //利用函数定义，递归求解取出最后一个元素的子集，然后只需给每一个集合追加上最后一个元素即可
            List<List<Integer>> lists = subsets(Arrays.copyOfRange(nums, 0, nums.length - 1));

            /*遍历每一个子集中的集合，然后给每一个集合追加最后一个元素*/
            int size = lists.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(lists.get(i));//注意new，否则传的是引用
                list.add(lastNum);//追加最后一个元素
                lists.add(list);//在原来的基础中追加新集合
                /*lists.add(lists.get(i));
                lists.get(i+1).add(lastNum);*/
            }

            return lists;
        }

        /**
         * 方法二：回溯
         */
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsets2(int[] nums) {
            List<Integer> trace = new ArrayList<>();

            //路径：trace  nums和start作为选择列表，因为不能重复选元素，需要一个start记录剩余可选元素的起始位置
            backtrace(trace, nums, 0);
            return result;
        }

        private void backtrace(List<Integer> trace, int[] nums, int start) {

            result.add(new ArrayList<>(trace));

            for (int i = start; i < nums.length; i++) {
                //做出选择
                trace.add(nums[i]);

                //回溯
                backtrace(trace, nums, i + 1);

                //撤销选择
                trace.remove(trace.size() - 1);
            }
        }
    }
}
