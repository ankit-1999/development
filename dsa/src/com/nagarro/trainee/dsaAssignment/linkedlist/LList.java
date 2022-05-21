package com.nagarro.trainee.dsaAssignment.linkedlist;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class LList<T> implements Iterable<T> {

	int size;
	Node<T> head;

	public LList() {
		this.size = 0;
	}

	// inner Node class
	public class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	// inner class for implementing iterator
	class CustomIterator<T> implements Iterator<T> {

		@SuppressWarnings("unchecked")
		Node<T> currNode = (Node<T>) head;

		@Override
		public boolean hasNext() {

			return currNode != null;
		}

		@Override
		public T next() {
			T value = currNode.data;
			currNode = currNode.next;
			return value;

		}

	}

	// insert at last
	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		size++;
		if (head == null) {
			head = newNode;
			return;
		}
		Node<T> tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = newNode;
	}

	// insert at position
	public void insertAtPosition(T data, int position) {
		if (position < 1 || position > size + 1) {
			System.out.println("Invalid Position");
		} else {
			Node<T> tmp = new Node<T>(data);
			if (position == 1) {
				tmp.next = head;
				size++;
				return;
			} else {
				Node<T> previous = null;
				Node<T> current = head;
				while (position != 1) {
					previous = current;
					current = current.next;
					position--;
				}
				previous.next = tmp;
				tmp.next = current;
				size++;
			}

		}
	}

	// delete node
	public void delete(T value) {
		if (head == null) {
			System.out.println("head is null");
			return;
		}
		if (head.data == value) {
			head = head.next;
			return;
		} else {
			Node<T> previous = null;
			Node<T> current = head;
			while (current.data != value && current.next != null) {
				previous = current;
				current = current.next;
			}
			if (current.next == null) {
				System.out.println("value not present in linked list");
			} else {
				previous.next = current.next;
			}
		}
	}

	// delete at position
	public void deleteAtPosition(int position) {
		if (head == null) {
			return;
		}
		if (position < 1 || position > size) {
			System.out.println("Invalid position");
			return;
		}
		if (position == 1) {
			head = head.next;
		} else {
			Node<T> previous = null;
			Node<T> current = head;
			while (position != 1) {
				previous = current;
				current = current.next;
				position--;
			}
			previous.next = current.next;
		}

	}

	// center of linked list
	public T center() {
		Node<T> slow = head;
		Node<T> fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;

	}

	// reverse a linked list
	public void reverse() {
		if (head == null && head.next == null) {
			return;
		}
		Node<T> previous = null;
		Node<T> current = head;
		Node<T> tmp = head;
		while (tmp.next != null) {
			tmp = current.next;
			current.next = previous;
			previous = current;
			current = tmp;
		}
		current.next = previous;
		head = current;

	}

	// LinkedList size
	public int size() {
		return size;

	}

	// print linked list
	public void print() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		}
		Node<T> tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + "->");
			tmp = tmp.next;
		}
		System.out.println("NULL");

	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new CustomIterator<T>();
	}

}
