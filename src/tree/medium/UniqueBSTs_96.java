package tree.medium;

/**
 * 求可以构成多少不同的二叉搜索树
 */
public class UniqueBSTs_96 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.numTrees(3);
        System.out.println(count);

    }

    static class Solution {
        /*给定一个根节点的值，所能构成BST的个数实际上是以这个给定的值为节点，左子树组合数与右子树组合数的乘积！
        * 可以构造辅助函数，通过扩展参数列表，递归求得区间[low,high]可以构成BST的个数*/
        public int numTrees(int n) {
            return count(1, n);
        }

        public int count(int low, int high) {
            /*基准条件
            * 当low>high时，区间是空区间，没有元素，而上一层递归是low=high，即区间只有一个元素，所以返回给上层递归一个1*/
            if (low > high)
                return 1;

            /*遍历[low,high]区间的所有节点，每次遍历以当前i值为根节点，递归求i节点的左右子树的可以构成BST的个数
            * result累加每次遍历的左右子树组合数的乘积*/
            int result = 0;
            for (int i = low; i <= high; i++) {
                int left = count(low, i - 1);
                int right = count(i + 1, high);
                result += left * right;
            }

            return result;
        }
    }
}

