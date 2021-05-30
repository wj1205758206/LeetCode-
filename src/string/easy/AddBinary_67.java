package string.easy;


public class AddBinary_67 {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {
        StringBuffer strSum = new StringBuffer();
        int sum = 0;

        int v1, v2;
        int carry = 0;  //进位标志
        int i = a.length() - 1;
        int j = b.length() - 1;
        /*按照二进制加法法则，从最低位相加开始算起*/
        while (i >= 0 || j >= 0) {
            /*两个字符串长度不相等时，处理完短的之后，还需要处理较长的二进制字符串
            当字符遇到算法运算时，可以考虑通过与'0'进行算法运算，相当于转为用ASCII码进行算数运算
            一旦处理完较短字符串，就作置0处理，这样与0相加减就没有什么影响*/
            v1 = i < 0 ? 0 : a.charAt(i) - '0';
            v2 = j < 0 ? 0 : b.charAt(j) - '0';
            /*每一位分别相加，还需加上进位*/
            sum = v1 + v2 + carry;
            /*逢二进一，并把进位标志置1，进位之后不要为了减去2*/
            if (sum >= 2) {
                carry = 1;
                sum = sum - 2;
            } else {
                /*不满2就不会产生进位*/
                carry = 0;
            }
            /*把当前循环计算的结果保存在缓冲区*/
            strSum.append(sum);
            i--;
            j--;
        }
        /*如果最高位产生进位，还需要将进位保存在缓冲区*/
        if (carry == 1)
            strSum.append(carry);
        /*反转字符串输出*/
        return strSum.reverse().toString();
    }

}
