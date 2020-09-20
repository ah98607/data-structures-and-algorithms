class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = pq.poll();
        }
        return result;
    }
}
/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0; // should not execute
        }
        return recFind(nums, 0, nums.length - 1, nums.length - k);
    }
    private int recFind(int[] nums, int start, int end, int expPartitionLocation) {
        int parLocation = partition(nums, start, end);
        if (parLocation == expPartitionLocation) {
            return nums[expPartitionLocation];
        }
        else if (parLocation > expPartitionLocation) {
            return recFind(nums, start, parLocation - 1, expPartitionLocation);
        }
        else {
            return recFind(nums, parLocation + 1, end, expPartitionLocation);
        }
    }
    private int partition(int[] nums, int start, int end) {
        int left = start;
        int right = end + 1;
        int pivot = nums[start];
        while (true) {
            while (left < end && nums[++left] < pivot);
            while (right > start && nums[--right] > pivot);
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
        }
        swap(nums, start, right);
        return right;
    }
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}*/