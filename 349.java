class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> or = new HashSet<>(),
                     ans = new HashSet<>();
        for (int aNums1 : nums1) or.add(aNums1);
        for(int aNums2 : nums2) {
            if(or.contains(aNums2)) ans.add(aNums2);
        }
        int[] res = new int[ans.size()];
        int i = 0;
        for(int aNums2 : ans) {
            res[i++] = aNums2;
        }
        return res;
    }

}