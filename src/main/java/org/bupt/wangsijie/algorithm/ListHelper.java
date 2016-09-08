package org.bupt.wangsijie.algorithm;

/**
 * Copyright © 2016 王思杰. All rights reserved.
 *
 * @Title: ListHelper.java
 * @Prject: CodingInterviews
 * @Package: utils
 * @Description: TODO
 * @author: 王思杰
 * @date: 2016年9月8日 下午10:48:14
 * @version: V1.0
 */
public class ListHelper<T> {

	/**
	 * listBuilder (根据数组构造一个链表)
	 * @param vals
	 * @return
	 *ListNode<T>
	 * @exception
	 * @since  1.0.0
	*/
	public ListNode<T> listBuilder(T[] vals) {
		if (vals == null || vals.length == 0) {
			return null;
		}
		ListNode<T> head = new ListNode<T>(vals[0]);
		ListNode<T> current = head;
		for (int i = 1; i < vals.length; i++) {
			current.next = new ListNode<T>(vals[i]);
			current = current.next;
		}
		return head;
	}

	/**
	 * printList (打印链表，每10个节点换一行)
	 * @param head
	 *void
	 * @exception
	 * @since  1.0.0
	*/
	public void printList(ListNode<T> head) {
		if (head == null) {
			return;
		}

		int count = 0;
		while (head != null) {
			System.out.print(head.value);
			if ((head = head.next) != null) {
				System.out.print(" --> ");
			}
			++count;
			if (count % 10 == 0) {
				System.out.println();
				count = 0;
			}
		}
		System.out.println();
	}

	/**
	 * reverseList (反转链表)
	 * @param head
	 * @return
	 *ListNode<T>
	 * @exception
	 * @since  1.0.0
	*/
	public ListNode<T> reverseList(ListNode<T> head) {
		if (head == null) {
			return head;
		}
		ListNode<T> next = head.next;
		head.next = null;
		ListNode<T> nextNext;
		while (next != null) {
			nextNext = next.next;
			next.next = head;
			head = next;
			next = nextNext;
		}
		return head;
	}

	public static void main(String[] args) {
		Integer[] vals = { 1, 2, 3, 4, 5, 6, 7, 8 };
		ListHelper<Integer> helper = new ListHelper<>();
		ListNode<Integer> head = helper.listBuilder(vals);
		helper.printList(head);
		head = helper.reverseList(head);
		helper.printList(head);
	}
}
