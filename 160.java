public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode A = headA;
        ListNode B = headB;
        ListNode[] tempA = new ListNode[100005];
        ListNode[] tempB = new ListNode[100005];
        int i, j;
        for(i = 0; A != null; i++, A = A.next) {
            tempA[i] = A;
        }
        for(j = 0; B != null; j++, B = B.next) {
            tempB[j] = B;
        }
        if(tempA[--i].val != tempB[--j].val)
            return null;
        ListNode res = tempA[i];
        for(;i >= 0 && j >= 0; i--, j--) {
            if(tempA[i].val != tempB[j].val) {
                return res;
            }
            res = tempA[i];
        }
        return res;
    }
}