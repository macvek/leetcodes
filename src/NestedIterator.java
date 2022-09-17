import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private int ptr = 0;
    private List<NestedInteger> data;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.data = nestedList;
    }

    private NestedIterator delegate;

    @Override
    public Integer next() {
        NestedInteger pointed = data.get(ptr);
        if (pointed.isInteger()) {
            ++ptr;
            return pointed.getInteger();
        }
        else if (delegate == null) {
            throw new RuntimeException("Expected to check for next before loading");
        }
        else {
            return delegate.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (ptr < data.size()) {
            NestedInteger pointed = data.get(ptr);
            if (pointed.isInteger()) {
                return true;
            }
            else {
                while(ptr < data.size()) {
                    if (delegate != null) {
                        if (delegate.hasNext()) {
                            return true;
                        } else {
                            delegate = null;
                            ++ptr;
                            continue;
                        }
                    }

                    NestedInteger candidate = data.get(ptr);
                    if (candidate.isInteger()) {
                        return true;
                    }
                    else {
                        delegate = new NestedIterator(candidate.getList());
                    }
                }
                return false;
            }
        }
        else {
            return false;
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */