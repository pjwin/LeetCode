package leetcode;

public class RemoveDupsLinkedList {

	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		first.next = new ListNode(1);
		first.next.next = new ListNode(2);
		ListNode mylist = deleteDuplicates(first);
		System.out.println(mylist);
		
		first = new ListNode(1);
		first.next = new ListNode(1);
		first.next.next = new ListNode(2);
		first.next.next.next = new ListNode(3);
		first.next.next.next.next = new ListNode(3);
		mylist = deleteDuplicates(first);
		System.out.println(mylist);
		
		first = new ListNode(9);
		mylist = deleteDuplicates(first);
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
}
