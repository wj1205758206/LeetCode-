package backtrace.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Permutations_46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Solution solution = new Permutations_46().new Solution();
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);

    }

    class Solution {
        /**
         * 回溯
         */
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> track = new ArrayList<>();//track 记录路径
            List<Integer> selectList = new ArrayList<Integer>();
            for (int num : nums) {
                selectList.add(num);
            }
            backtrace(track, selectList);//路径：track   选择列表：nums

            return result;
        }

        private void backtrace(List<Integer> track, List<Integer> selectList) {

            /*触发结束条件*/
            if (selectList.isEmpty()) {
                result.add(new ArrayList<>(track));
                return;
            }

            /*在选择列表范围内做出选择*/
            for (int i = 0; i < selectList.size(); i++) {

                //作出选择，添加到路径中
                Integer select = selectList.get(i);
                track.add(select);

                //将该选择从选择列表移除
                selectList.remove(i);

                //进入下一层决策树，继续回溯
                backtrace(track, selectList);

                //当前选择回溯结束，要撤销选择
                track.remove(track.size() - 1);
                selectList.add(i, select);
            }
        }
    }
}
