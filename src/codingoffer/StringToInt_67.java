package codingoffer;

/**
 * 字符串转整数
 */
public class StringToInt_67 {
    public static void main(String[] args) {
        Solution solution = new StringToInt_67().new Solution();
        System.out.println(solution.strToInt("-99999999999"));
    }

    class Solution {
        public int strToInt(String str) {
            int res = 0, boundary = Integer.MAX_VALUE / 10;
            int i = 0, sign = 1, length = str.length();
            if (length == 0) return 0;
            //替代trim()函数
            while (str.charAt(i) == ' ') {
                i++;
                //有可能全是空格
                if (i == length) return 0;
            }
            //标记符号
            if (str.charAt(i) == '-') sign = -1;
            if (str.charAt(i) == '-' || str.charAt(i) == '+') i++;
            //从第一个数字开始遍历
            for (int j = i; j < length; j++) {
                //数字不合法
                if (str.charAt(j) < '0' || str.charAt(j) > '9') break;
                //在下一次乘10之前，先判断是否越界，有可能大于，直接越界，也有可能刚好等于边界，但是加上最后一位数字就会越界
                //[-2147483648 , 2147483647]
                if (res > boundary || res == boundary && str.charAt(j) > '7')
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                //不越界，将字符串转换为整数
                res = res * 10 + (str.charAt(j) - '0');
            }
            //最后返回带符号的整数
            return sign * res;
        }
    }
}
