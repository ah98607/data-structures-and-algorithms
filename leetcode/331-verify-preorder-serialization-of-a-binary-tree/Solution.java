public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] sArray = preorder.split(",");
        int diff = 1;
        for(int i = 0; i < sArray.length; i++) {
            diff--;
            if(diff < 0) {
                return false;
            }
            if(!sArray[i].equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}