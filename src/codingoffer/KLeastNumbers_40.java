package codingoffer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 */
public class KLeastNumbers_40 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            Arrays.sort(arr);
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = arr[i];
            }
            return result;
        }

        /**
         * 快速排序切分数组
         *
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers2(int[] arr, int k) {
            if (k >= arr.length) return arr;
            return quickSort(arr, k, 0, arr.length - 1);
        }

        private int[] quickSort(int[] arr, int k, int l, int r) {
            int i = l;
            int j = r;
            while (i < j) {
                while (i < j && arr[j] >= arr[l]) j--;
                while (i < j && arr[i] <= arr[l]) i++;
                swap(arr, i, j);
            }
            swap(arr, l, i);
            if (i > k) return quickSort(arr, k, l, i - 1);
            if (i < k) return quickSort(arr, k, i + 1, r);
            return Arrays.copyOf(arr, k);
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        /**
         * TopK问题，大顶堆实现
         *
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers3(int[] arr, int k) {
            if (k == 0 || arr.length == 0) return new int[0];
            if (k >= arr.length) return arr;

            //重写比较器，实现大顶堆
            Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);

            for (int num : arr) {
                //堆中元素个数小于k，直接添加
                if (queue.size() < k) {
                    queue.add(num);
                } else if (num < queue.peek()) {    //如果堆元素个数超过k个，并且新添加的元素大于堆顶元素，直接跳过，如果小于，则弹出堆顶元素，向堆中添加这个新元素
                    queue.poll();                   //始终维护k个元素，这k个元素就是最小的k个元素
                    queue.add(num);
                }
            }

            int[] result = new int[queue.size()];
            int i = 0;
            for (Integer num : queue) {
                result[i++] = num;
            }

            return result;
        }
    }
}
