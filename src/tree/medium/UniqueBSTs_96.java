package tree.medium;

/**
 * 求可以构成多少不同的二叉搜索树
 */
public class UniqueBSTs_96 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.numTrees2(3);
        System.out.println(count);

    }

    static class Solution {
        /**
         * 方法一：遍历所有的节点，求各个节点左子树组合数与右子树组合数的乘积的累加和
         *
         * @param n BST的节点个数
         * @return 返回可以构成不同BST的个数
         */
        /*给定一个根节点的值，所能构成BST的个数实际上是以这个给定的值为节点，左子树组合数与右子树组合数的乘积！
         * 可以构造辅助函数，通过扩展参数列表，递归求得区间[low,high]可以构成BST的个数*/
        public int numTrees(int n) {
            return count(1, n);
        }

        public int count(int low, int high) {
            /*基准条件
             * 当low>high时，区间是空区间，没有元素，也就是对应着空节点null，但这也是一种情况，所以要返回1而不是返回0。
             * 如果返回0，左右子树的组合数乘积也就变成0了*/
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

        /**
         *
         * 第一种方法虽然可以实现，但是时间复杂度非常高，LeetCode存在超时的问题，因为方法一存在重叠子问题，
         * 已经遍历过的节点多次重复求左右子树的组合数乘积，即同一个区间的构成BST的个数重复求解，类似于2*3和3*2的问题。
         *
         * 方法二：可以使用动态规划消除重叠子问题，就是加一个备忘录
         *
         * @param n BST的节点个数
         * @return 返回可以构成不同BST的个数
         */
        int[][] nums;

        public int numTrees2(int n) {
            /*创建一个二维数组，用来记录区间[low,high]可以构成的BST的个数*/
            nums = new int[n + 1][n + 1];
            return count2(1, n);
        }

        public int count2(int low, int high) {
            /*基准条件
             * 当low>high时，区间是空区间，没有元素，也就是对应着空节点null，但这也是一种情况，所以要返回1而不是返回0。
             * 如果返回0，左右子树的组合数乘积也就变成0了*/
            if (low > high)
                return 1;

            /*二维数组初始化都为0，通过判断当前值是否为0，来得知是否之前的递归已经求解出这个区间的可以构成多少个BST
            * 如果之前已经求解出结果，就直接返回，无需再进行递归求解*/
            if (nums[low][high] != 0)
                return nums[low][high];

            /*遍历[low,high]区间的所有节点，每次遍历以当前i值为根节点，递归求i节点的左右子树的可以构成BST的个数
             * result累加每次遍历的左右子树组合数的乘积*/
            int result = 0;
            for (int i = low; i <= high; i++) {
                int left = count2(low, i - 1);
                int right = count2(i + 1, high);
                result += left * right;
            }

            /*每次求解出当前区间的结果时，都进行保存*/
            nums[low][high] = result;

            return result;
        }
    }
}

