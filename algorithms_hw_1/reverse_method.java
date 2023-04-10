package algorithms_hw_1;


public class reverse_method {
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        LinkedListReverse listReverser = new LinkedListReverse();
        ListNode reversedHead = listReverser.reverseList(head);

        ListNode node = reversedHead;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class LinkedListReverse {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
