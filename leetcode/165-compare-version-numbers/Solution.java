class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        while (index1 < v1.length && index2 < v2.length) {
            int temp = Integer.parseInt(v1[index1]) - Integer.parseInt(v2[index2]);
            if (temp > 0) {
                return 1;
            }
            if (temp < 0) {
                return -1;
            }
            index1++;
            index2++;
        }
        while (index1 < v1.length) {
            int temp = Integer.parseInt(v1[index1]);
            if (temp > 0) {
                return 1;
            }
            index1++;
        }
        while (index2 < v2.length) {
            int temp = Integer.parseInt(v2[index2]);
            if (temp > 0) {
                return -1;
            }
            index2++;
        }
        return 0;
    }
}