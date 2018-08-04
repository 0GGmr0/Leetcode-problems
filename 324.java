class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 1) return;
        Arrays.sort(nums);
        int len = nums.length;
        int[] a = new int[len];
        for(int i = (len - 1) / 2, j = len - 1, cou = 0; i >= 0; i--, j--) {
            a[cou++] = nums[i];
            if(cou == len) break;
            a[cou++] = nums[j];
        }
//        if(len % 2 == 1) {
//            a[len - 1] = a[1];
//            a[1] = nums[len -1];
//        }
        for(int i = 0; i < len; i++) nums[i] = a[i];
    }
}