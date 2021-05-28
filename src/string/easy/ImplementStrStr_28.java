package string.easy;


/**
 * 字符串匹配问题
 * 判断一个字符串是否包含指定的子字符串，并返回子字符串首个字符位置
 */
public class ImplementStrStr_28 {

    public static void main(String[] args) {

        int index = strStr3("", "");
        System.out.println(index);
    }

    /**
     * 方法一：直接调用indexOf方法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle, 0);
    }

    /**
     * 方法二：双重循环逐个比对needle和haystack每一个字符
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        //needle为空直接范围0，默认匹配成功
        if ("".equals(needle))
            return 0;
        //如果needle比haystack长度长，那么haystack一定不会包含needle，返回-1
        if (needle.length() > haystack.length())
            return -1;
        //变量k用来记录首次匹配needle第一个字符的位置，即准备开始匹配的位置
        int k = 0;

        //外层循环遍历haystack每一个字符
        for (int i = 0; i < haystack.length(); i++) {
            //记录当前开始匹配的位置，如果匹配成功，i就是首次匹配成功的首字符索引
            k = i;
            //循环遍历needle每一个字符，去和haystack匹配
            for (int j = 0; j < needle.length(); j++) {
                //需要保证k值不能越出haystack数组的边界，就k最大从haystack最后一个字符开始匹配
                if (k < haystack.length()) {
                    //如果当前字符匹配成功，j++，k++ 继续比对下一个字符
                    if (needle.charAt(j) == haystack.charAt(k)) {

                        k++;
                    }
                    //如果当前字符匹配不成功，则会跳出内层循环，从haystack下一个字符再开始进行匹配
                } else {
                    break;
                }

            }
            //外层循环遍历结束，如果成功匹配了haystack字符个数为needle的长度，则说明needle包含在haystack中，i就是起始位置
            if (k - i == needle.length())
                return i;
        }
        return -1;
    }

    /**
     * 方法三：按照String类的IndexOf方法的思路实现
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr3(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        //首先计算出最大的循环匹配次数，
        // 如果说haystack剩余的匹配字符的个数都小于needle的长度，说明haystack剩下的字符串肯定不会包含needle，也就没有必要继续循环匹配
        int max = haystack.length() - needle.length();

        for (int i = 0; i <= max; i++) {
            //从haystack中找到第一个与needle匹配的字符，即确定haystack开始匹配的起始位置
            if (haystack.charAt(i) != needle.charAt(0)) {
                /*while循环确定与needle首字符匹配的haystack的位置*/
                while (++i <= max && haystack.charAt(i) != needle.charAt(0)) ;
            }
            /*成功匹配第一个字符后，继续匹配剩余字符*/
            if (i <= max) {
                /*i+1确定下一个匹配位置*/
                int j = i + 1;
                /*end是成功匹配剩余的个数，因为已经匹配第一个，所以个数-1，即从j位置开始，往后找end个成功匹配的字符*/
                int end = j + needle.length() - 1;
                /*因为needle第一个字符已经匹配成功，所以从索引k=1开始匹配*/
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++) ;

                /*剩余字符匹配结束，如果j==end，说明剩余字符全部匹配成功，即在haystack中找到了needle*/
                if (j == end){
                    return i;
                }
            }
        }
        return -1;
    }

}
