package array.medium;
import java.util.*;

/**
 * 实现插入、删除、随机读取时间复杂度都为 O(1)
 */
public class InsertDeleteGetRandomO1_380 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());


    }

    /**
     * 要想随机读取时间复杂度为 O(1) 底层需要用数组实现，且数组必须是紧凑的
     * 底层用数组实现，在数组尾部插入、删除可以保证时间复杂度也为 O(1)
     * 删除操作，需要将要删除的元素先交换到数组的尾部，再进行删除，这样就不需要移动其它元素
     */
    static class RandomizedSet {
        int[] numbers = null;
        Map<Integer,Integer> numIndex = null;
        int len = 0;
        Random random = null;

        public RandomizedSet() {
            numbers = new int[10000];
            numIndex = new HashMap<>();
            random = new Random();
        }

        /**
         * len变量记录数组中最后一个元素的索引位置，在数组尾部进行插入操作
         * 同时，使用map集合保存val值与该值在数组中的索引之间的关系
         * @param val   待插入的元素
         * @return  返回是否插入成功
         */
        public boolean insert(int val) {
            if (numIndex.containsKey(val))
                return false;
            numbers[len] = val;
            numIndex.put(val,len);
            len++;
            return true;
        }

        /**
         * 移除指定的元素val
         * 将尾部元素的索引更新为要删除元素的索引，
         * 然后将数组尾部元素移动到待删除元素的位置，覆盖待删除元素
         * len--表示数组长度减一，相当于删除了指定的元素val
         * 最后还要删除掉map中val的映射关系
         * @param val   待删除元素
         * @return  返回是否删除成功
         */
        public boolean remove(int val) {
            if (!numIndex.containsKey(val))
                return false;
            numIndex.put(numbers[len-1], numIndex.get(val));
            numbers[numIndex.get(val)] = numbers[len-1];
            len--;
            numIndex.remove(val);
            return true;
        }

        /**
         * @return  随机返回索引为[0,len-1]范围内对应数组中的值
         */
        public int getRandom() {
            return numbers[random.nextInt(len)];
        }
    }
}
