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
		
		Map<Integer, ListNode> RecordMap = new HashMap<Integer, ListNode>();

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
		System.out.println(RecordMap.size());
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

		return head;

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
		}*/
		System.out.println(head);
	}
}
