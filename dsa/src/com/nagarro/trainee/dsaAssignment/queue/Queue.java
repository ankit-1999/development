package com.nagarro.trainee.dsaAssignment.queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
	int size = 0;
	Node<T> front;
	Node<T> back;

	public Queue() {
		this.size = 0;
	}

	class Node<T> {
		T data;
		Node<T> link;

		Node(T value) {
			this.data = value;
			this.link = null;
		}
	}

	// inner class for custom iterator
	class CustomIterator<T> implements Iterator<T> {

		Node<T> currNode = (Node<T>) front;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currNode != back.link;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T value = currNode.data;
			currNode = currNode.link;
			return value;
		}

	}

	// enqueue will insert element at back of queue
	public void enqueue(T value) {
		Node<T> tmp = new Node<T>(value);
		if (this.back == null) {
			this.front = tmp;
			this.back = tmp;
		} else {
			this.back.link = tmp;
			this.back = tmp;
		}

		size++;
	}

	// is empty will return false is queue is empty
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	// dequeue will delete element from the front of queue
	public void dequeue() {
		if (this.front == null) {
			System.out.println("queue is empty");
			return;
		}

		this.front = this.front.link;
		if (this.front == null) {
			this.back = null;
		}
		size--;

	}

	// peek will return front element
	public T peek() {
		return this.front.data;
	}

	// size of queue
	public int size() {
		return this.size;
	}

	// reverse of queue
	public void reverse() {
		if (this.front == null && this.front == this.back) {
			return;
		}
		Node<T> previous = null;
		Node<T> current = this.front;
		Node<T> tmp = this.front;
		while (tmp.link != null) {
			tmp = current.link;
			current.link = previous;
			previous = current;
			current = tmp;
		}
		current.link = previous;
		this.back = this.front;
		this.front = current;
	}

	// print will traverse from front till back and will print all elements
	public void print() {
		Node<T> tmp = front;
		while (tmp != null) {
			System.out.print(tmp.data + "->");
			tmp = tmp.link;
		}
		System.out.println("NULL");

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CustomIterator<T>();
	}

}
