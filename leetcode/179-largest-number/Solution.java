class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "0";
        }
        List<String> sList = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            sList.add(String.valueOf(nums[i]));
        }
        Collections.sort(sList, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sList.size(); i++) {
            sb.append(sList.get(i));
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                return sb.toString().substring(i);
            }
        }
        return "0";
    }
}