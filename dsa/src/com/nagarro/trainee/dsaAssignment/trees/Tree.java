package com.nagarro.trainee.dsaAssignment.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.nagarro.trainee.dsaAssignment.queue.Queue;

public class Tree<T> implements Iterable<T> {

	TreeNode<T> root;
	ArrayList<T> bfsArray = new ArrayList<T>();
	ArrayList<T> dfsArray = new ArrayList<T>();

	Tree() {
		this.root = null;
	}

	class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data) {
			this.data = data;
			this.children = new ArrayList<TreeNode<T>>();
		}

	}

	class BfsIterator<T> implements Iterator<T> {

		int index = 0;

		BfsIterator() {
			setBfsArray();
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < bfsArray.size();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T value = (T) bfsArray.get(index);
			index++;
			return value;
		}

	}

	class DfsIterator<T> implements Iterator<T> {

		int index = 0;

		DfsIterator() {
			setDfsArray(root);
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < dfsArray.size();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T value = (T) dfsArray.get(index);
			index++;
			return value;
		}
	}

	// setBfsArray will set value of node in bfs in array
	private void setBfsArray() {
		bfsArray = new ArrayList<T>();
		Queue<TreeNode<T>> queue = new Queue<TreeNode<T>>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) { // so that we can reach each level
				TreeNode<T> node = queue.peek();
				queue.dequeue();
				bfsArray.add(node.data);
				for (TreeNode item : node.children) { // for-Each loop to iterate over all childrens
					queue.enqueue(item);
				}
			}
		}
	}

	private void setDfsArray(TreeNode<T> node) {
		if (node == null) {
			return;
		}
		dfsArray.add(node.data);
		for (int i = 0; i < node.children.size(); i++) {
			setDfsArray(node.children.get(i));
		}

	}

	// insert will insert new nodes in tree
	public void insert(T parent, T child) throws Exception {
		TreeNode<T> tmp = new TreeNode<T>(child);
		if (root == null) {
			this.root = tmp;
			return;
		}
		TreeNode<T> nw = getByValue(parent);
		try {
			nw.children.add(tmp);
		} catch (Exception e) {
			System.out.println("invalid parent i.e value not inserted");
		}

		return;

	}

	// delete will delete all leave nodes
	public void delete(T data) {
		if (root.data == data) {
			root = null; // root is deleted and tree will become empty....
		}
		ArrayList<TreeNode<T>> tmp = getParent(data);
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i).data == data) {
				tmp.remove(i);
				return;
			}
		}
		return;

	}

	// get parent
	private ArrayList<TreeNode<T>> getParent(T data) {
		if (root == null) {
			return null;
		}
		ArrayList<TreeNode<T>> tmp = root.children;
		for (int i = 0; i < tmp.size(); i++) {
			boolean fic = contains(tmp.get(i), data);
			if (fic) {
				return tmp;
			}
		}
		return null;
	}

	// get node will return node with current value
	public TreeNode<T> getByValue(T data) {
		if (root.data == data) {
			return root;
		}
		ArrayList<TreeNode<T>> tmp = root.children;
		for (int i = 0; i < tmp.size(); i++) {
			boolean fic = contains(tmp.get(i), data);
			if (fic) {
				return tmp.get(i);
			}
		}
		return null;
	}

	// contains will return true if element is present else will return false
	public boolean contains(TreeNode node, T data) {
		if (node.data == data) {
			return true;
		}
		ArrayList<TreeNode<T>> tmp = node.children;
		for (int i = 0; i < tmp.size(); i++) {

			boolean fic = contains(tmp.get(i), data);
			if (fic) {
				return true;
			}
		}
		return false;
	}

	// get elements by level
	public void getbyLevel() {
		if (root == null)
			return;
		Queue<TreeNode<T>> queue = new Queue<TreeNode<T>>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) { // so that we can reach each level
				TreeNode<T> node = queue.peek();
				queue.dequeue();
				System.out.print(node.data + " ");
				for (TreeNode item : node.children) { // for-Each loop to iterate over all childrens
					queue.enqueue(item);
				}
			}
			System.out.println();
		}
	}

	// print breath first search
	public void printBfs() {
		if (root == null)
			return;
		Queue<TreeNode<T>> queue = new Queue<TreeNode<T>>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) { // so that we can reach each level
				TreeNode<T> node = queue.peek();
				queue.dequeue();
				System.out.print(node.data + " ");
				for (TreeNode item : node.children) { // for-Each loop to iterate over all childrens
					queue.enqueue(item);
				}
			}
			System.out.println();
		}
	}

	// print depth first search
	public void printDfs(TreeNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		for (int i = 0; i < node.children.size(); i++) {
			printDfs(node.children.get(i));
		}

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new DfsIterator<T>();
	}

}
