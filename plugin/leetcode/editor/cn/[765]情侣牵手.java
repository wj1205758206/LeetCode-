
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - uf.getCount();
    }
}

class UF {
    int count;
    int[] parent;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        parent[rootQ] = rootP;
        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return parent[x];
    }

    public int getCount() {
        return this.count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
