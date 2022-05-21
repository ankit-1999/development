package com.nagarro.trainee.dsaAssignment.priorityqueue;

import java.util.ArrayList;
import java.util.Iterator;

public class PriorityQueue implements Iterable<Integer> {

	ArrayList<Integer> data;
	ArrayList<Integer> rev;

	PriorityQueue() {
		this.data = new ArrayList<Integer>();
		;
	}

	// inner class for iterator
	class CustomIterator implements Iterator<Integer> {
		int index = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < data.size();
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			int value = data.get(index);
			index++;
			return value;
		}

	}

	// insert
	public void enqueue(Integer value) {
		data.add(value);
		upheapify(data.size() - 1);
	}

	private void upheapify(int i) {
		if (i == 0) {
			return;
		}

		int parent = (i - 1) / 2; // parent of current child
		if (data.get(i) < data.get(parent)) {
			swap(i, parent);
			upheapify(parent);
		}
	}

	// dequeue will delete peek element from priority queue
	public void dequeue() {
		if (this.size() == 0) {
			System.out.println("underflow");
			return;
		}
		swap(0, data.size() - 1);
		data.remove(data.size() - 1);
		downheapify(0);
	}

	private void downheapify(int pi) {
		int mini = pi;
		int li = 2 * pi + 1; // left child
		if (li < data.size() && data.get(li) < data.get(mini)) {
			mini = li;
		}
		int ri = 2 * pi + 2;
		if (ri < data.size() && data.get(ri) < data.get(mini)) {
			mini = ri;
		}
		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	// swap
	public void swapRev(int i, int j) {
		int ith = rev.get(i);
		int jth = rev.get(j);
		rev.set(i, jth);
		rev.set(j, ith);
	}

	public void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
	}

	// size will return size of PriorityQueue
	public int size() {
		if (this.data.size() == 0) {
			System.out.println("queue is empty");
			return 0;
		}
		return data.size();
	}

	// contains will return true if element is present in priority queue else will
	// return false
	public boolean contains(Integer value) {
		for (int i = 0; i < data.size(); i++) {
			if (value == data.get(i)) {
				System.out.println("value is present");
				return true;
			}
		}
		System.out.println("value not present");
		return false;
	}

	// peek will return top element from PriorityQueue
	public Integer peek() {
		if (this.size() == 0) {
			System.out.println("underflow");
			return null;
		}
		return data.get(0);
	}

	// print
	public void print() {
		for (int i = 0; i < data.size(); i++) {
			System.out.print(data.get(i) + " ");
		}
		System.out.println();
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new CustomIterator();
	}

	// reverse will convert this min heap into max heap
	public void reverse() {
		rev = new ArrayList<Integer>();
		for (int i = 0; i < data.size(); i++) {
			rev.add(data.get(i));
			reverseHeapify(rev.size() - 1);
		}
		this.data = (ArrayList<Integer>) rev.clone();
	}

	// insert reverse will insert in such a way that element with low priority will
	// get higher priority
	private void reverseHeapify(int i) {
		if (i == 0) {
			return;
		}

		int parent = (i - 1) / 2; // parent of current child
		if (rev.get(i) > rev.get(parent)) {
			swapRev(i, parent);
			reverseHeapify(parent);
		}
	}

}
