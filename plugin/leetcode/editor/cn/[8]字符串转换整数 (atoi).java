
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int myAtoi(String s) {
        s = s.trim(); //清除前导空格
        if (s.length() == 0) return 0; //极端情况 "       "
        //开头不是数字，也不是正负号开头，直接返回0
        if (!Character.isDigit(s.charAt(0))
                && s.charAt(0) != '-' && s.charAt(0) != '+') {
            return 0;
        }
        // long类型, 用来判断int类型的最大和最小值，是否溢出
        long result = 0L;
        boolean negative = s.charAt(0) == '-'; // 是否是负数
        int i = !Character.isDigit(s.charAt(0)) ? 1 : 0; //如果有符号，index从1开始

        // 遍历
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            // 累加数字
            result = result * 10 + (s.charAt(i) - '0');
            i++;
            //如果是正数，并超过了int最大值，则取最大值
            if (!negative && result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
                break;
            }
            //如果是负数，并超过了int最小值，则取最小值
            if (negative && result > 1L + Integer.MAX_VALUE) {
                result = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        // long类型再转回int类型
        return negative ? (int) -result : (int) result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
