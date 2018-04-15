public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> lists = new LinkedHashSet<>();
        for(;head != null; head = head.next) {
            if(lists.contains(head)) {
                return true;
            }
            else {
                lists.add(head);
            }
        }
        return false;
    }
}