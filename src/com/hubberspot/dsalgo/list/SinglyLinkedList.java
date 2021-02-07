package com.hubberspot.dsalgo.list;

public class SinglyLinkedList {

	private ListNode head;

	private static class ListNode {
		private int data; // Can be a generic type
		private ListNode next; // Reference to next ListNode in list

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void display() {
		ListNode current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.print("null");
	}

	public int length() {
		if(head == null) {
			return 0;
		}
		int count = 0;
		ListNode current = head;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}

	public void insert(int position, int value){
		// 1 -> 4 -> 5
		// 1 -> 6 -> 4 -> 5
		ListNode node = new ListNode(value);

		if(position == 1){
			node.next = head;
			head = node;
		} else {
			ListNode previous = head;
			int count = 1; // position - 1

			while(count < position - 1){
				previous = previous.next;
				count++;
			}

			ListNode current = previous.next;
			previous.next = node;
			node.next = current;
		}


	}

	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if (head == null) {
			head = newNode;
			return;
		}
		ListNode current = head;
		while (null != current.next) {
			current = current.next;
		}
		current.next = newNode;
	}

	public ListNode deleteFirst() {
		if(head == null) {
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}

	public void delete(int position){
		// position is valid and starting from 1
		// 3 -> 4 -> 7 -> 8 -> 9 -> null
		if(position == 1){
			head = head.next;
		} else {
			ListNode previous = head;
			int count = 1;
			while(count < position - 1){
				previous = previous.next;
				count++;
			}

			ListNode current = previous.next;
			previous.next = current.next;
		}
	}

	public ListNode deleteLast() {
		if(head == null) {
			return head;
		}

		if(head.next == null) {
			ListNode temp = head;
			head = head.next;
			return temp;
		}

		ListNode current = head;
		ListNode previous = null;

		while(current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null; // break the chain
		return current;
	}

	public boolean find(int searchKey) {
		if(head == null) {
			return false;
		}

		ListNode current = head;
		while(current != null) {
			if(current.data == searchKey) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public ListNode reverse() {
		if(head == null) {
			return null;
		}

		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;

		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	public ListNode getMiddleNode() {
		if(head == null) {
			return null;
		}
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}

	public ListNode getNthNodeFromEnd(int n) {
		if(head == null) {
			return null;
		}

		if(n <= 0) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}

		ListNode mainPtr = head;
		ListNode refPtr = head;

		int count = 0;

		while(count < n) {
			if(refPtr == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
			}
			refPtr = refPtr.next;
			count++;
		}

		while(refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}

	public ListNode insertInSortedList(int value) {
		ListNode newNode = new ListNode(value);

		if(head == null) {
			return newNode;
		}

		ListNode current = head;
		ListNode temp = null;

		while (current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}

		newNode.next = current;
		temp.next = newNode;
		return head;
	}

	public void deleteNode(int key) {
		ListNode current = head;
		ListNode temp = null;

		if(current != null && current.data == key){
			head = current.next;
			return;
		}

		while(current != null && current.data != key){
			temp = current;
			current = current.next;
		}

		if(current == null){
			return;
		}

		temp.next = current.next;
	}
	
	public boolean containsLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(fastPtr == slowPtr) {
				return true;
			}
		}
		return false;
	}

	public ListNode startNodeInALoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;

		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if(fastPtr == slowPtr) {
				return getStartingNode(slowPtr);
			}
		}
		return null;
	}

	private ListNode getStartingNode(ListNode slowPtr) {
		ListNode temp = head;
		while(temp != slowPtr){
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		return temp; // starting node of the loop
	}

	public void removeLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;

		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if(fastPtr == slowPtr) {
				removeLoop(slowPtr);
				return;
			}
		}
	}

	private void removeLoop(ListNode slowPtr) {
		ListNode temp = head;
		while(temp.next != slowPtr.next){
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		slowPtr.next = null;
	}

	public void createALoopInLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		// sll.createALoopInLinkedList();
		// System.out.println(sll.containsLoop());
		// System.out.println(sll.startNodeInALoop().data);
		// sll.removeLoop();

		sll.insertLast(5);
		sll.insertLast(7);
		sll.insertLast(9);
		sll.insertLast(11);

		sll.deleteLast();
		sll.deleteLast();
		sll.deleteLast();
		System.out.println(sll.deleteLast().data);

		sll.display();


	}
}