
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        //0.0.0.0 和 198.112.133.132
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        String track = "";
        bakctrack(s, track, 0);
        return result;
    }

    public void bakctrack(String s, String track, int start) {
        // +4指的是4个 .  198.144.143.1.
        // 按照. 分割后恰好分成4组，则说明ip合法
        if (track.length() == s.length() + 4
                && track.split("\\.").length == 4) {
            result.add(track.substring(0, track.length() - 1));
            return;
        }
        // 每一可以选择1~3和数字
        for (int i = 1; i <= 3; i++) {
            if (start + i <= s.length()
                    && track.split("\\.").length < 4) {
                // 截取选择的位数并判断是否合法,substring索引左闭右开
                String select = s.substring(start, start + i);
                if (!isValid(select)) {
                    continue;
                }

                //拼接此次的选择
                track = track + select + ".";
                //下次回溯从上次的索引位置接着选 start+i
                bakctrack(s, track, start + i);
                // 减掉1个点 和 select的长度
                track = track.substring(0, track.length() - 1 - select.length());
            }
        }
    }

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }
        //大于1位数时，不能有前导0
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        //范围必须是0~255
        if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
