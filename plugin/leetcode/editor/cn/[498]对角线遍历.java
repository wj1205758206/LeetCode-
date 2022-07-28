
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> result = new ArrayList<>();

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) return new int[]{};
        int m = mat.length;
        int n = mat[0].length;
        boolean isReserve = true;
        //处理第一行
        for (int j = 0; j < n; j++) {
            //统一都沿着左下角方向遍历，根据是否翻转进行翻转
            traverse(mat, 0, j, isReserve);
            isReserve = !isReserve;
        }
        for (int i = 1; i < m; i++) {
            traverse(mat, i, n - 1, isReserve);
            isReserve = !isReserve;
        }

        int[] res = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void traverse(int[][] mat, int x, int y, boolean isReserve) {
        List<Integer> temp = new ArrayList<>();
        for (int i = x, j = y; i < mat.length && j >= 0; i++, j--) {
            temp.add(mat[i][j]);
        }
        if (isReserve){
            Collections.reverse(temp);
        }
        result.addAll(temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
