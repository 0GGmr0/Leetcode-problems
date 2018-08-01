/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 1 ||  intervals.size() == 0) return intervals;
        List<Interval> ans = new LinkedList<>();
        Interval[] in = intervals.toArray(new Interval[0]);
        quickSort(in, 0, in.length - 1);
        int len = in.length;
        Interval temp = new Interval();
        for(int i = 0; i < len;i++) {
            if(i == 0) {
                temp.start = in[i].start;
                temp.end = in[i].end;
            } else {
                if(temp.end >= in[i].start && temp.start <= in[i].end) {
                    temp.end = Math.max(temp.end, in[i].end);
                    if(temp.start >= in[i].start) temp.start = in[i].start;
                } else {
                    ans.add(temp);
                    temp = new Interval(in[i].start, in[i].end);
                }
                if(i == len - 1) ans.add(temp);
            }
        }
        return ans;
    }

    static void quickSort(Interval[] in,int low, int high) {
        Interval e = in[low];
        int i = low, j = high;
        while(i < j) {
            while(i < j && in[j].start >= e.start) j--;
            if(i < j) in[i++] = in[j];
            while(i < j && in[i].start <= e.start) i++;
            if(i < j) in[j--] = in[i];
        }
        in[i] = e;
        if(low < i - 1) quickSort(in, low, i - 1);
        if(i + 1 < high) quickSort(in, i + 1, high);
    }
}