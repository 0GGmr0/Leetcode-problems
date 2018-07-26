/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        return dfs(head);
    }

    static Node dfs(Node head) {
        if(head == null) return null;
        Node l = head;
        while(l != null) {
            Node node = l.next;
            if(l.child != null) {
                l.child.prev = l;
                l.next = dfs(l.child);
                l.child = null;
                if(node != null) {
                    l.next.prev = l;
                    while (l.next != null) l = l.next;
                    l.next = node;
                    node.prev = l;
                }
            }
            l = node;
        }
        return head;
    }
}