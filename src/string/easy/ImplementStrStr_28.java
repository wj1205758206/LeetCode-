package string.easy;


/**
 * 字符串匹配问题
 * 判断一个字符串是否包含指定的子字符串，并返回子字符串首个字符位置
 */
public class ImplementStrStr_28 {

    public static void main(String[] args) {

        int index = strStr2("mississippi", "issipi");
        System.out.println(index);
    }

    /**
     * 方法一：直接调用indexOf方法
     * @param haystack
     * @param needle
     * @return
     */

    public static int strStr(String haystack, String needle){
        return haystack.indexOf(needle,0);
    }

    public static int strStr2(String haystack, String needle){
        if ("".equals(needle))
            return 0;
        if ("".equals(haystack) && !("".equals(needle)))
            return -1;
        int k = 0;
        int index = 0;
        for (int i = 0; i < needle.length(); i++){
            if (needle.charAt(i) == haystack.charAt(k)){
                k++;
            }else {
                i = -1;
            }
        }
        return -1;

    }

}
