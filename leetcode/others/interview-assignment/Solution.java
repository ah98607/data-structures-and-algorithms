// 题目：http://www.1point3acres.com/bbs/thread-430166-1-1.html、
// compile here: https://www.jdoodle.com/online-java-compiler

import java.util.*;
public class MyClass {
    public static void main(String[] args) {
		int[][] costs = {{200, 300},
		{500, 200},
		{100, 1000},
		{700, 300}};
		int min = minCost(costs);
	}
	public static int minCost(int[][] costs) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> iList = new ArrayList<Integer>();
	    List<String> sList = new ArrayList<String>();
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    map.put("NY", 0);
	    map.put("SF", 0);
		recFind(result, iList, sList, map, costs, 0);
		int totalCost = 0;
		return totalCost;
	}
	private static void recFind(List<List<Integer>> result, List<Integer> iList, List<String> sList, HashMap<String, Integer> map, int[][] costs, int start) {
	    //System.out.println("Calling function and start = " + start);
	    if (start ==  costs.length) {
	        if (Math.abs(map.get("NY") - map.get("SF")) <= 1) {
	            System.out.println("Cost combination is " + iList);
	            System.out.println("City combination is " + sList);
	            int totalCost = 0;
	            for (int i = 0; i < iList.size(); i++) {
	                totalCost += iList.get(i);
	            }
	            System.out.println("Total cost is " + totalCost);
	            result.add(new ArrayList<Integer>(iList));
	        }
	        return;
	    }
	    iList.add(costs[start][0]);
        sList.add("NY");
        map.put("NY", map.get("NY") + 1);
        recFind(result, iList, sList, map, costs, start + 1);
        map.put("NY", map.get("NY") - 1);
        sList.remove(sList.size() - 1);
        iList.remove(iList.size() - 1);
        
        iList.add(costs[start][1]);
        map.put("SF", map.get("SF") + 1);
        sList.add("SF");
        recFind(result, iList, sList, map, costs, start + 1);
        sList.remove(sList.size() - 1);
        map.put("SF", map.get("SF") - 1);
        iList.remove(iList.size() - 1);
	}
}
