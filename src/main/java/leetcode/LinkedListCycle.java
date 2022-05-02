package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    //Destructive
    public boolean hasCycle(ListNode head) {
        while (head != null && head.next != null) {
            if (head.val == 100000) return true;
            head.val = 100000;
            head = head.next;
        }
        return false;
    }

    //HashSet
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> myList = new HashSet<>();
        while (head.next != null) {
            if (myList.add(head)) {
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    //two pointers
    public boolean hasCycle3(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
