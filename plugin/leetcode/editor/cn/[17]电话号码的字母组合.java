
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<String, List<String>> phone = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        phone.put("2", Arrays.asList("a", "b", "c"));
        phone.put("3", Arrays.asList("d", "e", "f"));
        phone.put("4", Arrays.asList("g", "h", "i"));
        phone.put("5", Arrays.asList("j", "k", "l"));
        phone.put("6", Arrays.asList("m", "n", "o"));
        phone.put("7", Arrays.asList("p", "q", "r", "s"));
        phone.put("8", Arrays.asList("t", "u", "v"));
        phone.put("9", Arrays.asList("w", "x", "y", "z"));
        if (digits.isEmpty() || digits.length() == 0) {
            return result;
        }
        String track = "";
        backtrack(digits, track, 0);

        return result;
    }

    public void backtrack(String dights, String track, int i) {
        if (i == dights.length()) {
            result.add(new String(track));
            return;
        }

        List<String> select = phone.get(String.valueOf(dights.charAt(i)));

        for (String s : select) {
            track += s;
            backtrack(dights, track, i + 1);
            track = track.substring(0, track.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
