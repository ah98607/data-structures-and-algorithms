class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new TreeMap<Integer, Integer>();
        for (int i = 0; i < arr1.length; i++) {
            if (!freq.containsKey(arr1[i])) {
                freq.put(arr1[i], 1);
            }
            else {
                freq.put(arr1[i], 1 + freq.get(arr1[i]));
            }
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < freq.get(arr2[i]); j++) {
                arr1[index++] = arr2[i];
            }
            freq.remove(arr2[i]);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                arr1[index++] = entry.getKey();
            }
        }
        return arr1;
    }
}