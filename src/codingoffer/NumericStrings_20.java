package codingoffer;

/**
 * 判断表示数值的字符串
 */
public class NumericStrings_20 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isNumber(String s) {
            int n = s.length();
            int index = 0;
            boolean hasNum = false;
            boolean hasE = false;
            boolean hasSign = false;
            boolean hasDot = false;

            //去除前导空格
            while (index < n && s.charAt(index) == ' ') index++;

            //从头到尾扫描全部字符串
            while (index < n) {
                //判断整数部分
                while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    hasNum = true;
                    index++;
                }
                //全部由整数组成，则返回true
                if (index == n) return true;

                //到这说明扫描到了非整数，扫描到的是一个字符
                char c = s.charAt(index);
                //如果字符是e或者E
                if (c == 'e' || c == 'E') {
                    //如果前一个已经是e或者E了，或者前面不是一个整数(0-9),那么就不是一个数值，返回false
                    if (hasE || !hasNum)
                        return false;
                    hasE = true;
                    //e或者E后面需要跟着一个整数，所以将hasNum、hasSign、hasDot全部重置为false，重新开始遍历数值
                    hasNum = hasSign = hasDot = false;
                } else if (c == '+' || c == '-') {  //如果字符是正负号
                    //判断如果前面是还是正负号，或者是一个数值(0-9),或者是一个点，那么这就不是一个数值，返回false
                    if (hasSign || hasNum || hasDot)
                        return false;
                    hasSign = true;
                } else if (c == '.') {  //如果字符是点
                    //判断如果前面还是一个点，或者前面是一个e或者E，那么就不是一个数值，返回false
                    if (hasDot || hasE) {
                        return false;
                    }
                    hasDot = true;
                } else if (c == ' ') {  //如果中间字符出现了空格，这直接跳出循环，不用再继续扫描了，因为肯定不是一个数值
                    break;
                } else {
                    return false;   //上述情况不满足，就有可能扫描到了乱七八糟的字符，那么也不是一个数值，直接返回false
                }

                //继续扫描下一个字符
                index++;
            }

            //扫描继续，去除后导空格
            while (index < n && s.charAt(index) == ' ') index++;

            //如果是数值的话，必须的有数字，并且全部扫描完，没有中断
            return hasNum && index == n;
        }
    }
}
