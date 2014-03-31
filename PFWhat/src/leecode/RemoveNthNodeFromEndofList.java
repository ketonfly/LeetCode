package leecode;

import java.util.HashMap;
import java.util.Map;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode beforeNode=head,afterNode=head;
		
		for(int i = 0 ;i<n;i++){
			afterNode = afterNode.next;
		}
		if(afterNode==null){
			head = head.next;
			beforeNode = null;
			return head;
		}
		while(afterNode.next!=null){
			beforeNode = beforeNode.next;
			afterNode = afterNode.next;
		}
		ListNode tmp = beforeNode.next.next;
		
		beforeNode.next = tmp;
		
		return head;
		
		
		/*Map<Integer, ListNode> RecordMap = new HashMap<Integer, ListNode>();

		int i = 1;
		int location;
		ListNode beforeNode, afterNode;
		ListNode p = head;
		while (p.next != null) {

			RecordMap.put(i, p);

			p = p.next;

			i++;
		}
		RecordMap.put(i, p);
		
		location = RecordMap.size() - n + 1;
		if (location == 1) {
			p = head.next;
			head.next = null;
			return p;
		}
		beforeNode = RecordMap.get(location - 1);
		if (location == RecordMap.size()) {
			beforeNode.next = null;
			return head;
		}

		afterNode = RecordMap.get(location + 1);
		beforeNode.next = afterNode;

		return head;*/

		/*
		 * if (head == null) return null; ListNode p = head; ListNode q = head;
		 * for (int i = 0; i < n; i++) { q = q.next; } if (q == null) { head =
		 * head.next; p = null; return head; } while (q.next != null) { p =
		 * p.next; q = q.next; } ListNode tmp = p.next.next; p.next = tmp;
		 * return head;
		 */

	}

	public ListNode createList() {
		ListNode head, p, q;
		int[] test = { 1 };
		head = new ListNode(test[0]);
		q = p = head;
		for (int i = 1; i < test.length; i++) {
			p = new ListNode(test[i]);
			q.next = p;
			q = p;
		}
		return head;

	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndofList tt = new RemoveNthNodeFromEndofList();
		ListNode head = tt.createList();

		head = tt.removeNthFromEnd(head, 1);

		/*while (head.next != null) {
			System.out.println(head.val);
			head = head.next;
		}

		System.out.println(head.val);*/
	}
}
