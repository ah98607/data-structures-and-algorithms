class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals.length;
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
        Queue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        int rooms = 0;
        for (int i = 0; i < iList.size(); i++) {
            while (!pq.isEmpty() && pq.peek().end <= iList.get(i).start) {
                pq.poll();
            }
            pq.offer(iList.get(i));
            rooms = Math.max(rooms, pq.size());
        }
        return rooms;
    }
}