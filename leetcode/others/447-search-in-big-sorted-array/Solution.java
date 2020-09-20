/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int i = 1;
        while (reader.get(i - 1) < target) {
            i *= 2;
        }
        
        int left = 0;
        int right = i;
        int mid = 0;
        int rawIndex = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == reader.get(mid)) {
                rawIndex = mid;
                break;
            }
            else if (target > reader.get(mid)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (rawIndex == -1) {
            return -1;
        }
        else {
            while (rawIndex >= 0 && reader.get(rawIndex) == target) {
                rawIndex--;
            }
            return rawIndex+1;
        }
    }
}