class Solution {
    public String reorganizeString(String S) {
        if(S == null) return null;
        char[] ch = S.toCharArray();
        int[] a = new int[26];
        for (char c : ch) a[c - 97] += 1000;
        for(int i = 0; i < 26; i++) a[i] += i;
        int n = S.length();
        char[] ans = new char[n];
        int t = 1;
        Arrays.sort(a);
        for(int i = 0; i < 26; i++) {
            int ct = a[i] / 1000;
            int tmp = a[i] % 1000;
            if(ct > (n + 1) / 2) return "";
            for(int j = 0; j < ct; j++) {
                if(t >= n) t = 0;
                ans[t] = (char)(tmp + 'a');
                t += 2;
            }
        }
        return String.valueOf(ans);
    }
}