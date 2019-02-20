package leetcode;

public class ListTest {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode lr = ListNode.mergeTwoLists3(l1, l2);
		System.out.println(lr);
	}
}
