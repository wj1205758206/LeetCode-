
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] arr;
    int[] original;

    public Solution(int[] nums) {
        this.arr = nums;
        original = arr.clone();
    }

    public int[] reset() {
        arr = original;
        original = original.clone();
        return arr;
    }

    public int[] shuffle() {
        for (int i = 0; i < arr.length; i++) {
            swap(i, getRandomIndex(i, arr.length));
        }
        return arr;
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int getRandomIndex(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)
