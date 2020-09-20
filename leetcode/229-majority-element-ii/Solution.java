class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Integer candidateA = null;
        Integer candidateB = null;
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidateA == null) {
                candidateA = new Integer(nums[i]);
                countA = 1;
            }
            else if (candidateB == null && nums[i] != candidateA.intValue()) {
                candidateB = new Integer(nums[i]);
                countB = 1;
            }
            else if (nums[i] == candidateA.intValue()) {
                countA++;
            }
            else if (nums[i] == candidateB.intValue()) {
                countB++;
            }
            else if (countA == 0) {
                candidateA = new Integer(nums[i]);
                countA = 1;
            }
            else if (countB == 0) {
                candidateB = new Integer(nums[i]);
                countB = 1;
            }
            else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidateA != null && nums[i] == candidateA) {
                countA++;
            }
            if (candidateB != null && nums[i] == candidateB) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {
            result.add(candidateA);
        }
        if (countB > nums.length / 3) {
            result.add(candidateB);
        }
        return result;
    }
}