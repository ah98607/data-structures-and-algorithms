class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class MyCalendar {
    List<Interval> iList;
    public MyCalendar() {
        iList = new ArrayList<Interval>();
    }
    
    public boolean book(int start, int end) {
        int index = 0;
        while (index < iList.size() && iList.get(index).start < start) {
            index++;
        }
        if (index > 0 && start < iList.get(index - 1).end || index < iList.size() && end > iList.get(index).start) {
            return false;
        }
        iList.add(index, new Interval(start, end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */