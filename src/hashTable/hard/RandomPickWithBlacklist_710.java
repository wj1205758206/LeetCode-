package hashTable.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 黑名单中的随机数，等概率随机返回在指定范围内，但不在黑名单中的整数
 */
public class RandomPickWithBlacklist_710 {
    public static void main(String[] args) {
        int[] blackList = {2};
        Solution solution = new Solution(5,blackList);
        for (int i = 0; i < 5; i++)
            System.out.println(solution.pick());
    }

    /**
     * 方法一：
     * 使用map集合，将给定范围内的所有整数都保存在map中
     * 遍历黑名单，移除map中的黑名单中的整数
     * 随机生成的随机数必须包含在map中，否则继续生成下一个随机化
     * 执行效率与随机数有关，数多时容易超时
     */
    static class Solution {
        Map<Integer,Integer> map = null;
        Random random = null;


        public Solution(int n, int[] blacklist) {
            random = new Random();
            map = new HashMap<>();

            /*映射所有给定范围内的整数，保存到map中*/
            for (int i = 0; i < n; i++) {
                map.put(i,i);
            }

            /*移除黑名单中的整数*/
            for (int j = 0; j < blacklist.length; j++) {
                if (map.containsKey(blacklist[j]))
                    map.remove(blacklist[j]);
            }
        }

        public int pick() {
            int key;
            /*多次调用随机数函数，直到map中包含生成的随机数
            * 题目要求尽可能少的调用随机数函数，但是这个方法会多次调用随机数函数
            * 执行效率和随机数有关*/
            while (true) {
                key = random.nextInt(map.size());
                if (map.containsKey(key))
                    break;
            }
            return map.get(key);
        }
    }

    /**
     * 方法二：
     * 将整个[0,n)区间划分为[0,boundary)区间是正常索引，[boundary,n)区间是黑名单索引
     * 使用map将黑名单中的元素映射成正常的索引，相当于把黑名单中的数字都交换到了区间 [boundary, N) 中，同时把 [0, boundary) 中的黑名单数字映射到了正常数字
     * 随机数只需要在[0,boundary)这个区间产生即可，如果随机数是正常索引就会直接返回，如果随机数是黑名单索引，由于mapping映射的作用，会将黑名单索引进一步映射成正常索引
     *
     */
    static class Solution2 {
        int boundary;
        Map<Integer,Integer> mapping = null;
        Random random = null;

        public Solution2(int n, int[] blacklist) {
            mapping = new HashMap<>();

            random = new Random();

            /*[0,boundary)区间是正常索引，[boundary,n)区间是黑名单索引*/
            boundary = n - blacklist.length;

            /*这里只是将黑名单索引加入到mapping中，方便根据键判断当前遍历的索引是否在黑名单中*/
            for (int b : blacklist) {
                mapping.put(b,-1);
            }

            /*从数组的尾部开始遍历，相当于把黑名单索引都移动到[boundary,n)区间*/
            int last = n - 1;
            /*在映射黑名单索引时，要保证last一定不在黑名单中，才能起到黑名单索引转成正常索引的效果*/
            for (int b : blacklist) {
                /*如果当前黑名单索引本来就在[boundary,n)区间，那么就无需给这个黑名单索引在mapping建立映射
                * 只有处在[0,boundary)正常索引区间的黑名单索引，才需要重新建立映射
                * 如果本来就处于黑名单索引区间，则直接跳过，继续处理下一个黑名单索引*/
                if (b >= boundary)
                    continue;

                /*从数组尾部开始查找第一个不在黑名单中的正常索引*/
                while (mapping.containsKey(last))
                    last--;

                mapping.put(b,last);
                last--;
            }
        }
        public int pick() {
            /*在去除黑名单之后的范围内[0,boundary)，随机选取一个索引*/
            int index = random.nextInt(boundary);

            /*mapping中保存了黑名单的映射，如果索引命中了黑名单，会被映射到其他位置*/
            if (mapping.containsKey(index))
                return mapping.get(index);

            /*没有命中黑名单，就直接返回随机选取的这个索引*/
            return index;
        }
    }
}
