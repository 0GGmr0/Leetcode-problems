class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len == 0) return 0;
        quickSort(citations, 0, len - 1);
        int max = 0;
        for(int i = 0; i < len; i++) {
            if(citations[i] <= len - i) max = citations[i];
            else max = Math.max(max, len - i);
        }
        return max;
    }

    static void quickSort(int[] in,int low, int high) {
        int e = in[low];
        int i = low, j = high;
        while(i < j) {
            while(i < j && in[j] >= e) j--;
            if(i < j) in[i++] = in[j];
            while(i < j && in[i] <= e) i++;
            if(i < j) in[j--] = in[i];
        }
        in[i] = e;
        if(low < i - 1) quickSort(in, low, i - 1);
        if(i + 1 < high) quickSort(in, i + 1, high);
    }
}

//大佬写法，用桶的原理，先建造一个比N大一的数组，然后便利给定数组，如果这个数字是比长度长的
//那么直接放到桶的最后一个，否则就在对应的buckets[c]++；
//遍历一次之后，从之后开始倒着往前+ 什么时候达标即可输出

// public int hIndex(int[] citations) {
//     int n = citations.length;
//     int[] buckets = new int[n+1];
//     for(int c : citations) {
//         if(c >= n) {
//             buckets[n]++;
//         } else {
//             buckets[c]++;
//         }
//     }
//     int count = 0;
//     for(int i = n; i >= 0; i--) {
//         count += buckets[i];
//         if(count >= i) {
//             return i;
//         }
//     }
//     return 0;
// }