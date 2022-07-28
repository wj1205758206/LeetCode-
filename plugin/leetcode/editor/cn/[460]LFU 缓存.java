
//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {
    //使用一个 HashMap 存储 key 到 val 的映射，就可以快速计算 get(key)。
    Map<Integer, Integer> keyToVal;
    //使用一个 HashMap 存储 key 到 freq 的映射，就可以快速操作 key 对应的 freq。
    Map<Integer, Integer> keyToFreq;

    //可能有多个 key 拥有相同的 freq，所以 freq 对 key 是一对多的关系，即一个 freq 对应一个 key 的列表
    //希望 freq 对应的 key 的列表是存在时序的，便于快速查找并删除最旧的 key。
    //希望能够快速删除 key 列表中的任何一个 key，因为如果频次为 freq 的某个 key 被访问，那么它的频次就会变成 freq+1，就应该从 freq 对应的 key 列表中删除，加到 freq+1 对应的 key 的列表中
    //LinkedHashSet 顾名思义，是链表和哈希集合的结合体。链表不能快速访问链表节点，但是插入元素具有时序；哈希集合中的元素无序，但是可以对元素进行快速的访问和删除
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    int minFreq;
    int capacity;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        incrFreq(key); //返回之前访问频率先加1
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        /**
         * 如果key已经存在了，直接put进去，并且freq加1
         */
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            incrFreq(key);
            return;
        }

        /**
         * 如果key不存在，在put进去之前，先判断容量满了吗
         * 如果满了，先删除freq最小的key 然后再将key put进去，并更新keyToFreq 和 freqToKeys
         */
        if (keyToVal.size() >= capacity) {
            removeMinFreq();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFreq = 1;

    }

    public void removeMinFreq() {
        //最小freq可能有多个key，我们需要删除最先被插入了key
        LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
        int deleteKey = keyList.iterator().next();
        keyList.remove(deleteKey);
        //如果keyList空了，还需要更新freqToKeys
        if (keyList.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        //更新keyToVal 和 keyToFreq
        keyToVal.remove(deleteKey);
        keyToFreq.remove(deleteKey);
    }

    public void incrFreq(int key) {
        //freq自增加1 再put回去
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        //更新freqToKeys
        //从原来的freq移除，并放入到freq+1的set中去
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        //如果原来的freq移除之后空了，还需要删除freq对应的keyList，同时需要判断删除的freq是否是minFreq，如果是更新minFreq++
        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
