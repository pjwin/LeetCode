package leetcode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val) return mergeTwoLists(list2, list1);

        ListNode head = list1;
        while (true) {
            if (list1.val == list2.val || (list1.val < list2.val && list1.next != null && list1.next.val > list2.val)) {
                ListNode temp = list2.next;
                list2.next = list1.next;
                list1.next = list2;
                list1 = list2;
                list2 = temp;
                if (list2 == null) break;
            } else if (list1.val < list2.val) {
                if (list1.next == null) {
                    list1.next = list2;
                    break;
                } else {
                    list1 = list1.next;
                }
            }
        }
        return head;
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
