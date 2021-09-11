package codingoffer;

/**
 * 替换空格
 */
public class ReplaceSpace_05 {
    public static void main(String[] args) {
        Solution solution = new ReplaceSpace_05().new Solution();
        System.out.println(solution.replaceSpace2("We are happy."));
    }

    class Solution {
        public String replaceSpace(String s) {
            return s.replace(" ", "%20");
        }

        public String replaceSpace2(String s) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(s.charAt(i));
                }
            }

            return sb.toString();
        }
    }
}
