public class Solution {
    public String getPermutation(int n, int k) {
        // adjust k
        k = k - 1;
        // get initial "factor"
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }
        // prepare number and used
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] used = new boolean[n];
        // get each bit
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int exp = k / factor;
            System.out.println(exp);
            int cur = 0;
            // find (exp)th unused number
            for (int j = 0; j < n; j++) {
                if (used[j]) {
                    continue;
                }
                else {
                    if (cur == exp) {
                        sb.append(nums[j]);
                        used[j] = true;
                        break;
                    }
                    else {
                        cur++;
                    }
                }
            }
            k = k % factor;
            if (n - 1 - i > 0) {
                factor = factor / (n - 1 - i);
            }
        }
        return sb.toString();
    }
}