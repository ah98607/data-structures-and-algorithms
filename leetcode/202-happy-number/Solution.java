class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> isVisited = new HashSet<Integer>();
        while (n != 1) {
            String s = String.valueOf(n);
            int temp = 0;
            for (int i = 0; i < s.length(); i++) {
                int digit = Integer.parseInt(s.substring(i, i + 1));
                temp += digit * digit;
            }
            if (isVisited.contains(temp)) {
                return false;
            }
            else {
                isVisited.add(temp);
            }
            n = temp;
        }
        return true;
    }
}