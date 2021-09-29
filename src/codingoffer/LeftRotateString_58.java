package codingoffer;

/**
 * 左旋转字符串
 */
public class LeftRotateString_58 {
    public static void main(String[] args) {

    }

    class Solution {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n, s.length()) + s.substring(0, n);
        }

        public String reverseLeftWords2(String s, int n) {
            StringBuilder res = new StringBuilder();
            for (int i = n; i < s.length(); i++)
                res.append(s.charAt(i));
            for (int i = 0; i < n; i++)
                res.append(s.charAt(i));
            return res.toString();
        }
    }
}
