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


//大哥做法
// class Solution {
//     public String reorganizeString(String S) {
//         int N = S.length();
//         int[] count = new int[26];
//         for (char c: S.toCharArray()) count[c-'a']++;
//         PriorityQueue<MultiChar> pq = new PriorityQueue<MultiChar>((a, b) ->
//             a.count == b.count ? a.letter - b.letter : b.count - a.count);

//         for (int i = 0; i < 26; ++i) if (count[i] > 0) {
//             if (count[i] > (N + 1) / 2) return "";
//             pq.add(new MultiChar(count[i], (char) ('a' + i)));
//         }

//         StringBuilder ans = new StringBuilder();
//         while (pq.size() >= 2) {
//             MultiChar mc1 = pq.poll();
//             MultiChar mc2 = pq.poll();
//             /*This code turns out to be superfluous, but explains what is happening
//             if (ans.length() == 0 || mc1.letter != ans.charAt(ans.length() - 1)) {
//                 ans.append(mc1.letter);
//                 ans.append(mc2.letter);
//             } else {
//                 ans.append(mc2.letter);
//                 ans.append(mc1.letter);
//             }*/
//             ans.append(mc1.letter);
//             ans.append(mc2.letter);
//             if (--mc1.count > 0) pq.add(mc1);
//             if (--mc2.count > 0) pq.add(mc2);
//             }
//         }

//         if (pq.size() > 0) ans.append(pq.poll().letter);
//         return ans.toString();
//     }
// }
// class MultiChar {
//     int count;
//     char letter;
//     MultiChar(int ct, char ch) {
//         count = ct;
//         letter = ch;
//     }
// }