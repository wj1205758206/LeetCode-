package codingoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 把数组排成最小的数(自定义字符串比较大小)
 */
public class SortArrayForMinNumber_45 {
    public static void main(String[] args) {
        Solution solution = new SortArrayForMinNumber_45().new Solution();
        System.out.println(solution.minNumber2(new int[]{121, 12}));
    }

    class Solution {
        List<String> list = new ArrayList<>();

        public String minNumber(int[] nums) {
            if (nums.length == 0) return "";
            Arrays.sort(nums);
            List<String> track = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            backtrack(nums, 0, track, used);

            return minValString(list);

        }

        private String minValString(List<String> list) {
            String min = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                String s = list.get(i);
                if (smaller(s, min))
                    min = s;
            }
            return min;
        }

        private boolean smaller(String s, String min) {
            int n = s.length();
            int i = 0;
            while (i < n) {
                if (s.charAt(i) == min.charAt(i)) {
                    i++;
                } else if (s.charAt(i) < min.charAt(i)) {
                    return true;
                }
            }
            return false;
        }

        private void backtrack(int[] nums, int start, List<String> track, boolean[] used) {
            if (start == nums.length) {
                String res = "";
                for (String s : track) {
                    res += s;
                }
                list.add(res);
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                if (used[i])
                    continue;

                used[i] = true;
                track.add(String.valueOf(nums[i]));
                backtrack(nums, start + 1, track, used);
                track.remove(track.size() - 1);
                used[i] = false;
            }
        }

        /**
         * 自定义字符串排序
         *
         * @param nums
         * @return
         */
        public String minNumber2(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = String.valueOf(nums[i]);
            }

            //使用快排，但是必须自定义字符串排序规则
            quickSort(strs, 0, strs.length - 1);

            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(str);
            }
            return sb.toString();
        }

        private void quickSort(String[] strs, int l, int r) {
            if (l >= r) return;
            int i = l;
            int j = r;
            while (i < j) {
                //若拼接字符串 x + y > y + x 则 x “大于” y   x + y = y + x话，说明x=y，排不排序都行，可以直接继续比较下一个
                while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
                //反之，若 x + y < y + x ，则 x “小于” y ；
                while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i--;
                String temp = strs[i];
                strs[i] = strs[j];
                strs[j] = temp;
            }
            String t = strs[i];
            strs[i] = strs[l];
            strs[l] = t;
            quickSort(strs, l, i - 1);
            quickSort(strs, i + 1, r);
        }
    }
}
