class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> iList = new ArrayList<Interval>();
        for (int i = 0; i < intervals.length; i++) {
            iList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        int index = 0;
        while (index < iList.size() && iList.get(index).start < newInterval[0]) {
            index++;
        }
        iList.add(index, new Interval(newInterval[0], newInterval[1]));
        List<Interval> merge = new ArrayList<Interval>();
        int prev = 0;
        for (int i = 1; i < iList.size(); i++) {
            if (iList.get(prev).end >= iList.get(i).start) {
                iList.get(prev).end = Math.max(iList.get(prev).end, iList.get(i).end);
            }
            else {
                merge.add(iList.get(prev));
                prev = i;
            }
        }
        merge.add(iList.get(prev));
        int[][] res = new int[merge.size()][2];
        for (int i = 0; i < merge.size(); i++) {
            res[i][0] = merge.get(i).start;
            res[i][1] = merge.get(i).end;
        }
        return res;
    }
}