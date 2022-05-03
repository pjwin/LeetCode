package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return null;
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode lt;
		if (l1.val <= l2.val) {
			lt = new ListNode(l1.val);
			l1 = l1.next; 
		} else {
			lt = new ListNode(l2.val);
			l2 = l2.next;
		}
		ListNode lr = lt;
		
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				lt.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				lt.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			lt = lt.next;
		}
		if (l1 == null && l2 != null) lt.next = l2;
		if (l1 != null && l2 == null) lt.next = l1;
		
		return lr;
	}
	
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists2(l1, l2.next);
			return l2;
		}
	}

	public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = l1 == null ? l2:l1;	
		return dummy.next;
	}
	
	public boolean hasCycle(ListNode head) {
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
	
	public static void main(String[] args) {
		ListNode zero = new ListNode(3);
		ListNode one = new ListNode(2);
		ListNode two = new ListNode(0);
		ListNode three = new ListNode(-4);
		
		zero.next = one;
		one.next = two;
		two.next = three;
		three.next = one;
		System.out.println(zero.hasCycle(zero));
		
		zero = new ListNode(1);
		one = new ListNode(2);
		zero.next = one;
		one.next = zero;
		System.out.println(zero.hasCycle(zero));
		
		zero = new ListNode(1);
		System.out.println(zero.hasCycle(zero));
		
		zero = new ListNode(1);
		one = new ListNode(2);
		zero.next = one;
		System.out.println(zero.hasCycle(zero));
		
	}
}