
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        if (k >= arr.length) return arr;
        //v2-v1实现大顶堆，堆内始终维护这 k 个较小元素
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (num < queue.peek()) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
