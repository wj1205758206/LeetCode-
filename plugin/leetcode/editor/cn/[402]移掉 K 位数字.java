
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder sb = new StringBuilder();
        int remains = num.length() - k; //去掉k个数，也就是需要保留len-k长度
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && sb.length() != 0 && c < sb.charAt(sb.length() - 1)) {
                //如果当前数字比上一个数字小，就把上一个偏大的数去掉，高位始终保留较小的数
                sb.deleteCharAt(sb.length() - 1);
                k--; //一共去除k个数
            }
            //去除前导0
            if (c == '0' && sb.length() == 0) continue;
            sb.append(c);
        }
        //按理说到这，k=0了，那么截取[0,len) 区间
        // 但也有可能while结束，k还没有减到0，所以需要再去掉剩下的数
        String result = sb.substring(0, Math.max(sb.length() - k, 0));
        return result.length() == 0 ? "0" : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
