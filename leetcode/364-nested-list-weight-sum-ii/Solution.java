/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList.size() == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        recFind(map, 0, nestedList);
        int sum = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int levelSum = 0;
            for (Integer num : entry.getValue()) {
                levelSum += num;
            }
            sum += (map.size() - entry.getKey()) * levelSum;
        }
        return sum;
    }
    private void recFind(Map<Integer, List<Integer>> map, int level, List<NestedInteger> nestedList) {
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<Integer>());
        }
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                map.get(level).add(item.getInteger());
            }
            else {
                recFind(map, level + 1, item.getList());
            }
        }
    }
}