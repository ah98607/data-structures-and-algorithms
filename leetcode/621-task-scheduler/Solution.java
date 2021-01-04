class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[tasks[i] - 'A']);
        }
        int tasksWithMaxFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == maxFreq) {
                tasksWithMaxFreq++;
            }
        }
        int temp = (n + 1) * (maxFreq - 1) + tasksWithMaxFreq;
        if (temp < tasks.length) {
            return tasks.length;
        }
        return temp;
    }
}