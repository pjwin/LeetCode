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
}
