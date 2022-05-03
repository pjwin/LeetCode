package leetcode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        //find the first non-val node
        while (head != null && head.val == val) {
            head = head.next;
        }
        //list was empty or all vals
        if (head == null) return head;

        //mark the start
        ListNode zero = new ListNode(-1, head);

        ListNode prev = zero;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;

        }
        return zero.next;
    }
}
