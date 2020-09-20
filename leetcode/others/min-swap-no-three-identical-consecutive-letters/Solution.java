public class Solution {
    public static int minSwapNoThreeIndenticalConsecutiveLetters(String s) {
        
        int count = 0;
        //baaabbaabbba
        do {

            if (s.contains("aaabb")) {
                s = s.replace("aaabb", "ababb");
                count++;
            }
            if(s.contains("bbbaa")) {
                s = s.replace("bbbaa", "babaa");
                count++;
            }
            if (s.contains("aaa")) {
                s = s.replace("aaa", "aab");
                count++;
            }
            if (s.contains("bbb")) {
                s = s.replace("bbb", "bba");
                count++;
            }
        } while (s.contains("aaa") || s.contains("bbb"));
        return count;
    }
    public static void main(String[] args) {
        String s = "baaaaa";
        System.out.println("For " + s + ", swaps: " + minSwapNoThreeIndenticalConsecutiveLetters(s));

        s = "baaabbaabbba";
        System.out.println("For " + s + ", swaps: " + minSwapNoThreeIndenticalConsecutiveLetters(s));

        s = "ababba";
        System.out.println("For " + s + ", swaps: " + minSwapNoThreeIndenticalConsecutiveLetters(s));
    }
}