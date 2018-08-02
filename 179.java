class Solution {
    public String largestNumber(int[] nums) {
         if(nums == null) return null;
         int len = nums.length;
         String[] s = new String[len];
         for(int i = 0; i < len; i++) s[i] = String.valueOf(nums[i]);
         Arrays.sort(s, (String s1, String s2)->((s2 + s1).compareTo(s1 + s2)));
         StringBuilder ans = new StringBuilder();
         if(s[0].equals("0") ) return "0";
         for(int i = 0; i < len; i++) ans.append(s[i]);
         return ans.toString();
     }
 }