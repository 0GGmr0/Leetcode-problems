//
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        int lengh = nums.length;
//        int judge = 0;
//        int[] res = new int[2];
//        for (int i = 0; i < lengh; i++) {
//            for (int j = i + 1; j < lengh; j++) {
//                if (nums[i] + nums[j] == target) {
//                    res[0] = i;
//                    res[1] = j;
//                    return res;
//                }
//            }
//        }
//        return res;
//    }
//}


import static java.util.Arrays.fill;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] pre = new int[100005];
        int[] res = new int[2];
        int N = 50000;
        fill(pre, -1);
        int len = nums.length;
        for(int i = 0;i < len; i++) {
            pre[nums[i] + N] = i;
        }
//        int judge = target/2;
        for(int i = 0; i < len; i++) {
            if(nums[i] + N <= target + 2 * N) {
                if(pre[target + N - nums[i]] != -1 && pre[target + N - nums[i]] != i) {
                    res[0] = i;
                    res[1] = pre[target + N - nums[i]];
                    return res;
                }
            }
        }
        return res;
    }
}