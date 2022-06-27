
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 *
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            //(rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数
            int num = (rand7() - 1) * 7 + rand7(); //等概率生成[1,49]范围的随机数
            if (num <= 40) {
                return num % 10 + 1; //拒绝采样，只取1~40，40是10的倍数，并返回[1,10]范围的随机数
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
