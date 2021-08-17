package backtrace.medium;

import java.util.*;

/**
 * 电话号码的字母组合
 */
public class LetterCombinationsOfPhoneNumber_17 {
    public static void main(String[] args) {
        String digits = "23";

        Solution solution = new LetterCombinationsOfPhoneNumber_17().new Solution();
        System.out.println(solution.letterCombinations(digits));
    }

    class Solution {
        /**
         * 回溯
         */
        Map<String, List<String>> phone = new HashMap<>();
        List<String> result = new ArrayList<>();

        public List<String> letterCombinations(String digits) {

            //存放字母数字的映射
            phone.put("2", Arrays.asList("a", "b", "c"));
            phone.put("3", Arrays.asList("d", "e", "f"));
            phone.put("4", Arrays.asList("g", "h", "i"));
            phone.put("5", Arrays.asList("j", "k", "l"));
            phone.put("6", Arrays.asList("m", "n", "o"));
            phone.put("7", Arrays.asList("p", "q", "r", "s"));
            phone.put("8", Arrays.asList("t", "u", "v"));
            phone.put("9", Arrays.asList("w", "x", "y", "z"));

            if (digits.isEmpty() || digits.length() == 0)
                return result;

            String track = "";

            /*回溯
             * 路径：track
             * 选择列表：数字对应的字母集合*/
            backtrack(track, digits, 0);

            return result;
        }

        private void backtrack(String track, String digits, int start) {

            //触发结束条件
            if (start == digits.length()) {
                result.add(track);
                return;
            }

            List<String> select = phone.get(String.valueOf(digits.charAt(start)));

            //从选择列表中作出选择
            for (int i = 0; i < select.size(); i++) {

                //作出选择
                track += select.get(i);

                //继续下一层的回溯
                backtrack(track, digits, start + 1);

                //撤销选择
                track = track.substring(0, track.length() - 1);
            }
        }
    }
}
