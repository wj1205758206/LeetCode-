package string.easy;

/**
 * 翻转字符串
 */
public class ReverseString_344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        Sulotion sulotion = new Sulotion();
        sulotion.reverseString(s);

        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }



    }
    static class Sulotion {
        /**
         * 方法一：使用左右双指针，左右挨个交换字符
         * @param s 传入的字符串数组
         */
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            char c;
            while (left < right) {
                c = s[left];
                s[left] = s[right];
                s[right] = c;
                left++;
                right--;
            }
        }
    }
}
