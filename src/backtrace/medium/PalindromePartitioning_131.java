package backtrace.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分割回文串
 */
public class PalindromePartitioning_131 {

    Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        String s = "aab";

        Solution solution = new PalindromePartitioning_131().new Solution();
        System.out.println(solution.partition(s));
    }

    class Solution {
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> partition(String s) {
            if (s.isEmpty() || s.length() == 0)
                return result;

            List<String> track = new ArrayList<>();

            char[] charArray = s.toCharArray();

            backtrack(track, charArray, 0);

            return result;
        }

        private void backtrack(List<String> track, char[] s, int start) {
            //触发结束条件
            if (start == s.length) {
                result.add(new ArrayList<>(track));
                return;
            }

            //子串是连续的，每次从start往后遍历
            for (int i = start; i < s.length; i++) {


                if (!map.containsKey(new String(s, start, i - start + 1))) {
                    //每次从start开始，截取长度为i的子串，并判断截取的这个子串是否是回文串
                    if (!isPalindrome(s, start, i))
                        continue;
                }


                //作出选择
                track.add(new String(s, start, i - start + 1));


                //继续回溯
                backtrack(track, s, i + 1);

                //撤销选择
                track.remove(track.size() - 1);
            }
        }

        private boolean isPalindrome(char[] s, int start, int end) {
            while (start < end) {
                if (s[start] != s[end])
                    return false;
                start++;
                end--;
            }

            map.put(new String(s, start, end - start + 1), true);
            return true;
        }
    }
}
