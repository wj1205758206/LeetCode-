package backtrace.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 */
public class RestoreIPAddresses_93 {
    public static void main(String[] args) {
        String s = "010010";

        Solution solution = new RestoreIPAddresses_93().new Solution();
        System.out.println(solution.restoreIpAddresses(s));
    }

    class Solution {
        List<String> result = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {

            if (s.isEmpty() || s.length() < 4 || s.length() > 12)
                return result;

            String track = "";

            backtrack(track, s, 0);

            return result;
        }

        private void backtrack(String track, String s, int start) {
            if (track.length() == s.length() + 4 && track.split("\\.").length == 4) {
                result.add(track.substring(0, track.length() - 1));
            }

            for (int i = 1; i <= 3; i++) {

                if (start + i <= s.length() && track.split("\\.").length < 4) {
                    String select = s.substring(start, start + i);
                    if (!isValid(select))
                        continue;

                    track = track + select + ".";

                    backtrack(track, s, start + i);

                    track = track.substring(0, track.length() - 1 - select.length());
                }
            }
        }

        private boolean isValid(String select) {
            if (select.length() == 0)
                return false;
            if (select.length() > 1 && select.startsWith("0"))
                return false;
            if (Integer.parseInt(select) < 0 || Integer.parseInt(select) > 255)
                return false;
            return true;
        }
    }
}
