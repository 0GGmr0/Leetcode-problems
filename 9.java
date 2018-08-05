class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0) ) return false;
        int ans = 0;
        while(ans < x) {
            ans =ans * 10 + x % 10;
            x /= 10;
        }
        return ans == x || x == ans / 10;
    }
}