class Solution {
    public void deleteNode(ListNode node) {
          ListNode n = node.next;
          node.next = n.next;
          node.val = n.val;
    }
}