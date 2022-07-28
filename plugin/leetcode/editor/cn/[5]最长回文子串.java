
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        //因为要求最长的回文子串，所以得遍历，以每一个字符为中心进行判断
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i); //奇数长度
            String s2 = palindrome(s, i, i + 1);//偶数长度，两个中心
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            // 双指针，向两边展开
            left--;
            right++;
        }
        return s.substring(left + 1, right); //左闭右开
    }
}
//leetcode submit region end(Prohibit modification and deletion)
