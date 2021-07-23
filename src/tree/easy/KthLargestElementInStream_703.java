package tree.easy;

import javax.swing.*;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 返回第 K 个大的元素
 */
public class KthLargestElementInStream_703 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargestElementInStream_703().new KthLargest(3, new int[]{1, 1});
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(4));
        System.out.println(kthLargest.add(4));
        System.out.println(kthLargest.add(4));


    }

    /**
     * 方法一：将数组元素放入list集合中，每次add元素时给list调用sort排序，并返回第 K 大的元素
     */
    /*class KthLargest {
        List<Integer> list = new ArrayList<>();
        int kth;

        public KthLargest(int k, int[] nums) {
            this.kth = k;
            for (int num : nums) {
                list.add(num);
            }
        }

        public int add(int val) {
            list.add(val);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            if (kth >= list.size())
                return list.get(0);
            return list.get(list.size() - kth);
        }
    }*/

    /**
     * 方法二：使用使用优先级队列实现的最小堆
     * 当add元素时，如果当前堆大小超过了 K 个，就直接弹出堆顶元素，也就是相当于堆始终维护 K 个元素
     * 那么堆顶的那个元素就是第 K 个最大元素
     */
    class KthLargest {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                add(num);
            }

        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > this.k)
                minHeap.poll();

            return minHeap.peek();
        }
    }
}
