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