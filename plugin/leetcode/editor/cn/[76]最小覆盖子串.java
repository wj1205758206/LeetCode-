
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        //维护两个map记录窗口中的符合条件的字符以及need的字符
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //先初始化need
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        //记录当前窗口中符合need要求的字符的数量,当valid == need.size()时即可shrik窗口
        int vaild = 0;
        int start = 0, len = Integer.MAX_VALUE;
        //一次遍历找“可行解”
        while (right < s.length()) {
            //更新窗口
            char c = s.charAt(right);
            right++;//窗口扩大
            //其实并不需要将s中所有的都加入windowsmap，只需要将need中的加入即可
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                //如果满足了need中字符数量的需要，则说明找到了一个valid
                if (window.get(c).equals(need.get(c))) {
                    vaild++;
                }
            }

            //shrink左边界，找符合条件的最优
            while (vaild == need.size()) {
                //不断“缩小”找满足条件的len最短值,并记录最短的子串的起始位序start
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //更新窗口——这段代码逻辑几乎完全同上面的更新窗口
                char d = s.charAt(left);
                left++;//窗口缩小
                if (need.containsKey(d)) {
                    //若一进去就将window对应的键值缩小，就永远不会满足下面的if，while也会一直执行，直到left越界，
                    // 因此，尽管和上面对窗口的处理几乎一样，但是这个处理的顺序还是很关键的！要细心！
                    // 所以先if判断，再更新window
                    if (window.get(d).equals(need.get(d))) {
                        vaild--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
