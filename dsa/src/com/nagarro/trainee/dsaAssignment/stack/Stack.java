package com.nagarro.trainee.dsaAssignment.stack;

import java.util.Iterator;

import com.nagarro.trainee.dsaAssignment.linkedlist.LList.Node;

// stack implementation using linkedlist.
public class Stack<T> implements Iterable<T> {
	int size = 0;
	Node<T> top = null;

	Stack() {
		this.size = 0;
	}

	class Node<T> {
		T data;
		Node<T> link;

		Node(T data) {
			this.data = data;
			this.link = null;
		}
	}

	// inner class for iterator
	class CustomIterator<T> implements Iterator<T> {

		Node<T> currNode = (Node<T>) top;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currNode != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T value = currNode.data;
			currNode = currNode.link;
			return value;
		}

	}

	// push will insert data at top of stack.
	public void push(T value) {
		Node<T> tmp = new Node<T>(value);
		tmp.link = top;
		top = tmp;
		size++;
	}

	// pop will delete top most element form stack.
	public void pop() {
		if (top == null) {
			System.out.println("stack underflow");
			return;
		}
		top = top.link;
		size--;
	}

	// peek will give top element on the stack.
	public T peek() {
		if (top == null) {
			System.out.println("stack is empty");
			return null;
		}
		return top.data;
	}

	// contains will search for given value in stack if present will return true
	// else false.
	public boolean contains(T value) {
		if (top == null) {
			return false;
		}
		Node<T> tmp = top;
		while (tmp.link != null) {
			if (tmp.data == value) {
				return true;
			}
			tmp = tmp.link;
		}
		return false;
	}

	// size will return size of stack
	public int size() {
		return size;
	}

	// reverse will reverse the stack
	public void reverse() {
		if (top == null && top.link == null) {
			return;
		}
		Node<T> previous = null;
		Node<T> current = top;
		Node<T> tmp = top;
		while (tmp.link != null) {
			tmp = current.link;
			current.link = previous;
			previous = current;
			current = tmp;
		}
		current.link = previous;
		top = current;
	}

	// print will print stack i.e top most element will be printed first.
	public void print() {
		if (top == null) {
			return;
		}
		Node<T> tmp = top;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.link;
		}
		System.out.println();

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CustomIterator<T>();
	}

}
