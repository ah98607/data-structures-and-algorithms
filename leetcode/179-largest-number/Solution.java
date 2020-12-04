class Solution {
    public String largestNumber(int[] nums) {
        Queue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(String.valueOf(nums[i]));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                return sb.toString().substring(i);
            }
        }
        return "0";
    }
}