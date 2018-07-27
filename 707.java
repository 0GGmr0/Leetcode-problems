import com.sun.glass.ui.SystemClipboard;

/**
 * @program: learn
 * @description:
 * @author: ggmr
 * @create: 2018-07-27 09:34
 */
public class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
    }
    private ListNode head;
    private ListNode l;
    private int len;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode();
        len = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        l = head.next;
        if(index < 0 || index > len - 1) return -1;
        for(int i = 0; i < index; i++) l = l.next;
        return l.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        l = new ListNode();
        l.val = val;
        l.next = head.next;
        head.next = l;
        len++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        l = head;
        while(l.next != null) l = l.next;
        ListNode node = new ListNode();
        node.val = val;
        l.next = node;
        len++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        l = head;
        if(index > len || index < 0) return;
        ListNode node = new ListNode();
        node.val = val;
        if(index == len) {
            while(l.next != null) l = l.next;
            l.next = node;
        } else {
            for(int i = 0; i < index; i++) l = l.next;
            node.next = l.next;
            l.next = node;
        }
        len++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        l= head;
        if(index > len - 1 || index < 0) return;
        for(int i = 0; i < index; i++)  l = l.next;
        l.next = l.next.next;
        len--;
    }



    public static void main(String[] args) {
//        ["MyLinkedList","addAtHead","addAtHead","deleteAtIndex","addAtIndex",
//         "addAtHead","addAtHead","addAtHead","get","addAtTail","addAtIndex","addAtHead"]
//        [[],[4],[9],[8],[3],[1],[3,6],[3]]
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(5);
        obj.addAtTail(2);
        obj.deleteAtIndex(1);
        obj.addAtIndex(1,9);
        obj.addAtHead(4);
        obj.addAtHead(9);
        obj.addAtHead(8);
        obj.get(3);
        obj.addAtTail(1);
        obj.addAtIndex(3, 6);
        obj.addAtHead(3);
        System.out.println(2);
    }
}
