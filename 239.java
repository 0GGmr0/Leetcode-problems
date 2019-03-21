class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1 || k == 1) return nums;
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> list = new ArrayDeque<>();
        list.addFirst(0);
         for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= nums[list.peekFirst()]) {
                while(!list.isEmpty()) list.pollFirst();
                list.addFirst(i);
            } else {
                while(nums[list.peekLast()] <= nums[i]) list.pollLast();
                if(!list.isEmpty() && i - list.peekFirst() >= k) list.pollFirst();
                list.addLast(i);
            }
            if(i >= k - 1) {
                res[i - k + 1] = nums[list.peekFirst()];
            }
        }
        return res;
    }
}