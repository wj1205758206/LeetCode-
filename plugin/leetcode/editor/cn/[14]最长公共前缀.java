
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        //将第一个str作为基准
        String prefix = strs[0];
        //两两比较
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            //只要出现空串，直接结束，最长公共前缀就为空串
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        //返回两个字符串的最长前缀
        return str1.substring(0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
