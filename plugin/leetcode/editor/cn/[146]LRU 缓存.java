
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    //哈希表+双向链表 = 哈希链表
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key); //将这个key变成最近使用过的，然后再返回
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key); //如果这个key存在，放入之后，使其变成最近使用过的
            return;
        }

        if (cache.size() >= capacity) {
            //如果容量满了，需要移除最老的key，也就是链表中头节点
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value); //将新的kv添加到链表尾部
    }

    public void makeRecently(int key) {
        //变成最近使用过的，就是将key从链表头部删除，重新插入到尾部
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
