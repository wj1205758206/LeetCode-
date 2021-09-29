package codingoffer;

/**
 * 翻转单词顺序
 */
public class ReverseWordInSentence_58 {
    public static void main(String[] args) {
        Solution solution = new ReverseWordInSentence_58().new Solution();
        System.out.println(solution.reverseWords(" "));
    }

    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            if (s.isEmpty()) return "";
            String[] strings = s.split(" ");
            System.out.println(strings.length);
            StringBuilder sb = new StringBuilder();
            for (int i = strings.length - 1; i >= 0; i--) {
                if (strings[i].equals("")) {
                    continue;
                }
                sb.append(strings[i] + " ");

            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }
}
