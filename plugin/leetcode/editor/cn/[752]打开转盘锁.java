
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }

        Set<String> visited = new HashSet<>();

        int step = 0;

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                String node = queue.poll();

                if (deads.contains(node)) {
                    continue;
                }

                if (target.equals(node)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(node, j);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }
                    String down = minusOne(node, j);
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }

    public String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
