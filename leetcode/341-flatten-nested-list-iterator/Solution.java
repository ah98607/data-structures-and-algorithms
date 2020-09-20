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
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Iterator<Integer> myIterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> iList = new ArrayList<Integer>();
        recFind(nestedList, iList);
        myIterator = iList.iterator();
    }
    
    private void recFind(List<NestedInteger> nestedList, List<Integer> iList) {
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                iList.add(nestedList.get(i).getInteger());
            }
            else {
                recFind(nestedList.get(i).getList(), iList);
            }
        }
    }

    @Override
    public Integer next() {
        return myIterator.next();
    }

    @Override
    public boolean hasNext() {
        return myIterator.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */