package codingoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 有重复字符的字符串进行全排列(结果不能有重复排列)
 */
public class StringPermutation_38 {
    public static void main(String[] args) {
        Solution solution = new StringPermutation_38().new Solution();
        String[] strings = solution.permutation("suvyls");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    class Solution2 {
        List<String> result = new ArrayList<>();

        public String[] permutation(String s) {
            if (s.isEmpty() || s.length() == 0)
                return null;
            StringBuilder track = new StringBuilder();
            boolean[] used = new boolean[s.length()];

            backtrack(s, track, used);

            Collections.sort(result);
            String[] res = new String[result.size()];
            int index = 0;
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }

            return res;
        }

        private void backtrack(String s, StringBuilder track, boolean[] used) {
            if (track.length() == s.length()) {
                result.add(track.toString());
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                //剪枝，避免同一层出现重复字符
                if ((i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i - 1]) || used[i])
                    continue;

                used[i] = true;
                track.append(s.charAt(i));

                backtrack(s, track, used);

                track.deleteCharAt(track.length() - 1);
                used[i] = false;
            }
        }
    }

    class Solution {
        List<String> rec;
        boolean[] vis;

        public String[] permutation(String s) {

            rec = new ArrayList<String>();
            vis = new boolean[s.length()];


            StringBuilder perm = new StringBuilder();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s1 = new String(chars);

            backtrack(s1, perm);

            String[] recArr = new String[rec.size()];
            for (int i = 0; i < rec.size(); i++) {
                recArr[i] = rec.get(i);
            }
            return recArr;
        }

        public void backtrack(String s, StringBuilder perm) {
            if (s.length() == perm.length()) {
                rec.add(perm.toString());
                return;
            }
            for (int j = 0; j < s.length(); j++) {
                if (vis[j] || (j > 0 && !vis[j - 1] && s.charAt(j - 1) == s.charAt(j))) {
                    continue;
                }
                vis[j] = true;
                perm.append(s.charAt(j));
                backtrack(s, perm);
                perm.deleteCharAt(perm.length() - 1);
                vis[j] = false;
            }
        }
    }

}
