package leecode;

import Algorithm.CreateLinkedList;
import leecode.basic.ListNode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if ( head == null || head.next == null) {
			return head;
		}
		ListNode p, q;

		p = head;
		q = p.next;
		while (q.next != null) {
			if (q.val == p.val) {
				q = q.next;
			} else {
				p.next = q;
				p = q;
			}
		}
		if (p.val == q.val) {
			p.next = q.next;
		}
		else {
			p.next = q;
		}
		return head;

	}
	public static void main(String []args){
		RemoveDuplicatesfromSortedList r = new RemoveDuplicatesfromSortedList();
		int []arr = {1,1,2,3,3};
		CreateLinkedList cll = new CreateLinkedList(arr);
		ListNode head = cll.func();
		
		r.deleteDuplicates(head);
		while(head.next!=null){
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println(head.val);
	}
}
