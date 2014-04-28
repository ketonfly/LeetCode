package self.sort;

import Algorithm.CreateLinkedList;
import leecode.basic.ListNode;

public class insertSort {
	public void sortArray(int[] arr) {
		int tmp;
		for (int i = 0; i < arr.length; i++) {
			tmp = arr[i];
			for (int j = 0; j < i; j++) {

				if (tmp > arr[j]) {
					continue;
				} else {
					int k = i;
					while (k > j) {
						arr[k] = arr[k - 1];
						k--;
					}
					arr[j] = tmp;
					break;
				}
			}
		}
	}

	public ListNode sortList(ListNode head) {
		ListNode tmp, khead, p, q;
		if (head == null || head.next == null) {
			return head;
		}
		khead = head.next;
		head.next = null;
		while (khead != null) {
			tmp = khead;
			khead = khead.next;

			
			p = head;
			//开始仅仅有一个node的情况
			if (head.next == null) {
				if (tmp.val >= head.val) {
					head.next = tmp;
					tmp.next = null;
				} else {
					tmp.next = head;
					head = tmp;
				}
				continue;
			}
			//对每个node 进行处理
			q = p.next;
			while (q != null) {
				if (q.val >= tmp.val) {
					p.next = tmp;
					tmp.next = q;
					break;
				} else {
					q = q.next;
					p = p.next;
				}
			}
			if(q == null){
				p.next = tmp;
				tmp.next = null;
			}

		}

		return head;

	}

	public static void main(String[] args) {
		insertSort is = new insertSort();
		int arr[] = { 1, 3, 5, 2, 4, 6 };
		CreateLinkedList cll = new CreateLinkedList(arr);
		ListNode head = cll.func();
		is.sortList(head);
		while(head.next != null){
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println(head.val);
		is.sortArray(arr);
		for (int i : arr) {
			System.out.println(i);
		}

	}
}
