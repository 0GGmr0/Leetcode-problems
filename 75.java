class Solution {
    public void sortColors(int[] nums) {
        if(nums == null) return;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        for (int num : nums) map.put(num, map.get(num) + 1);
        int cou = 0;
        for(int i : map.keySet()) {
            int k = map.get(i);
            while(k-- > 0) nums[cou++] = i; 
        }
    }
}