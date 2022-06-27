
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        //去除前导和后导空格
        s.trim();
        if (s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        //按照 空格 划分
        String[] split = s.split(" ");
        //反向遍历
        for (int i = split.length - 1; i >= 0; i--) {
            //单词之间有多个空格的直接忽略
            if (split[i].equals(" ")) continue;
            //反向拼接单词和空格
            sb.append(split[i] + " ");
        }
        //去除最后的拼接的一个空格
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
