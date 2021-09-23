package codingoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class StreamMedian_41 {
    public static void main(String[] args) {

    }

    class MedianFinder {

        List<Integer> list = null;

        public MedianFinder() {
            this.list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            Collections.sort(list);
            if (list.size() % 2 == 1) {
                return list.get(list.size() / 2);
            } else {
                int mid = list.size() / 2;
                return (list.get(mid) + list.get(mid - 1)) / 2.0;
            }
        }
    }

    /**
     * 维护一个大顶堆和小顶堆
     */
    class MedianFinder2 {

        PriorityQueue<Integer> minHeap = null;
        PriorityQueue<Integer> maxHeap = null;

        public MedianFinder2() {
            //小顶堆存放较多的右半部分元素
            minHeap = new PriorityQueue<>((v1, v2) -> v1 - v2);
            //大顶堆存放较少的左半部分元素
            maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        }

        public void addNum(int num) {
            //大小不相等，说明左半部分少，
            if (maxHeap.size() != minHeap.size()) {
                minHeap.add(num);//最添加新元素之前，先添加到小顶堆中，即从数组右半部分选出最小值
                maxHeap.add(minHeap.poll());//将右半部分中最小值放入到左半部分中
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() != minHeap.size())
                return minHeap.peek();
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
