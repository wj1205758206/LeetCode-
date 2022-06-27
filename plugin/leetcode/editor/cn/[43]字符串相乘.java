
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        // 结果最多为 m + n 位数
        int[] result = new int[m + n];
        // 从个位数开始逐位相乘,两个指针 i，j 在 num1 和 num2 上游走，计算乘积
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //计算两个数相乘
                int mul = (num1.charAt(i) - '0') * (num2.charAt(i) - '0');
                //乘积在 result 对应的索引位置
                int p1 = i + j, p2 = i + j + 1;
                //将乘积叠加到 result 的正确位置
                int sum = mul + result[p2];
                result[p2] = sum % 10;
                result[p1] = sum / 10;
            }
        }
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (i < result.length) {
            sb.append(result[i]);
            i++;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
