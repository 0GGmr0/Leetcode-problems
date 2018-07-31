class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(),
                              ans = new HashMap<>();
        for(int i : nums1) {
            if(map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        int len = 0;
        for(int i : nums2) {
            if(map.containsKey(i) && map.get(i) > 0) {
                if(ans.containsKey(i)) ans.put(i, ans.get(i) + 1);
                else ans.put(i, 1);
                map.put(i, map.get(i) - 1);
                len++;
            }
        }
        int a[] = new int[len];
        int k = 0;
        for(Integer i : ans.keySet()) {
            int j = ans.get(i);
            while(j-- != 0) a[k++] = i;
        }
        return a;
    }
}