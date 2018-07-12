import java.util.Scanner;


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] a = new int[256];
        for(int i = 0; i < 256; i++) a[i] = -1;

        int len = s.length();
        //当前计量的起始长度
        int start = 0;
        //最长长度
        int max = 0;
        //当前最长长度
        int curmlen = 0;
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(a[ch] == -1) { //如果单词没出现过
                a[ch] = i;
                curmlen++; //当前最大值加一
            } else {
                //更新最大值
                if(curmlen > max) max = curmlen;
                curmlen -= (a[ch] - start);
                for(int j = start; j < a[ch]; j++) a[s.charAt(j)] = -1;
                start = a[ch] + 1;
                a[ch] = i;
            }
        }
        if(curmlen > max) max = curmlen;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String s = sc.next();
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
