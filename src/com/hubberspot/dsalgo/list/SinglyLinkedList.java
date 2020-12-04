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

	public ListNode deleteLast() {
		if(head == null || head.next == null) {
			return head;
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
		sll.createALoopInLinkedList();
		System.out.println(sll.containsLoop());
	}
}