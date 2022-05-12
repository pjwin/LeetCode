package leetcode;

public class RemoveDupsLinkedList {

	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		first.next = new ListNode(1);
		first.next.next = new ListNode(2);
		ListNode mylist = deleteDuplicates2(first);
		System.out.println(mylist);
		
		first = new ListNode(1);
		first.next = new ListNode(1);
		first.next.next = new ListNode(1);
		first.next.next.next = new ListNode(3);
		first.next.next.next.next = new ListNode(3);
		mylist = deleteDuplicates2(first);
		System.out.println(mylist);
		
		first = new ListNode(9);
		mylist = deleteDuplicates2(first);
		System.out.println(mylist);
		
		mylist = deleteDuplicates2(null);
		System.out.println(mylist);
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		if (head.next != null) {
			head.next = deleteDuplicates(head.next);
		}
		if (head.next == null || head.val != head.next.val) {
			return head;
		} else {
			return head.next;
		}
	}
	
	public static ListNode deleteDuplicates2(ListNode head) {
	    ListNode current = head;
	    while (current != null && current.next != null) {
	        if (current.next.val == current.val) {
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	}

	public ListNode deleteDuplicates3(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			if (curr.val == curr.next.val) curr.next = curr.next.next;
			else curr = curr.next;
		}
		return head;
	}
}
