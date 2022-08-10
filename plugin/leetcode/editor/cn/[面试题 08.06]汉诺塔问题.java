
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            int num = A.get(A.size() - 1);
            C.add(num);
            A.remove(A.size() - 1);
            return;
        }

        move(n - 1, A, C, B);

        int num = A.get(A.size() - 1);
        C.add(num);
        A.remove(A.size() - 1);

        move(n - 1, B, A, C);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
