import java.util.*;

public class Solution {
    public static int minDeleteToMakeUnique(final String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // collect character's appearance count
        final Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            }
            else {
                freq.put(c, 1);
            }
        }
        //
        int deleteCount = 0;
        final Set<Integer> countSet = new HashSet<Integer>();
        for (final Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            if (!countSet.contains(count)) {
                countSet.add(count);
            }
            else {
                while (countSet.contains(count) && count > 0) {
                    count--;
                    deleteCount++;
                }
                if (count > 0) {
                    countSet.add(count);
                }
            }
        }
        return deleteCount;
    }
    public static void main(final String[] args) {
        String s = "abcd";
        System.out.println("For " + s + ", need to delete " + minDeleteToMakeUnique(s));

        s = "eeeeffff";
        System.out.println("For " + s + ", need to delete " + minDeleteToMakeUnique(s));

        s = "aabbffddeaee";
        System.out.println("For " + s + ", need to delete " + minDeleteToMakeUnique(s));
    }
}