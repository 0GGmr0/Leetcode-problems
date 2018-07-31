class Solution {
    public boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int lena = a.length;
        int lenb = b.length;
        if(lena != lenb) return false;
        else {
            for(int i = 0; i < lena; i++) {
                if(a[i] != b[i]) return false;
            }
        }
        return true;
    }
}