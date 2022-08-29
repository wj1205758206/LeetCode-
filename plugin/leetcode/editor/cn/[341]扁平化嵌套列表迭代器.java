
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    public Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger node : nestedList) {
            traverse(node, result);
        }
        this.iterator = result.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    public void traverse(NestedInteger root, List<Integer> result){
        if (root.isInteger()){
            result.add(root.getInteger());
            return;
        }
        for (NestedInteger child : root.getList()){
            traverse(child, result);
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)
