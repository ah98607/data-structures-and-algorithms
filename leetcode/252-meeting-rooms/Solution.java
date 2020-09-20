class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 2) {
            return true;
        }
        List<Interval> iList = new ArrayList<Interval>();
        for (int i = 0; i < intervals.length; i++) {
            iList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(iList, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        for (int i = 1; i < iList.size(); i++) {
            if (iList.get(i).start < iList.get(i - 1).end) {
                return false;
            }
        }
        return true;
    }
}