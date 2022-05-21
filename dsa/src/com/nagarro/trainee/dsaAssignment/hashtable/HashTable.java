package com.nagarro.trainee.dsaAssignment.hashtable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.nagarro.trainee.dsaAssignment.linkedlist.LList;


public class HashTable<K, V> implements Iterable<K> {
	private class HMNode {
		K key;
		V value;

		HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	ArrayList<HMNode> tmp = new ArrayList<HMNode>();

	class CustomIterator<K> implements Iterator<K> {

		int index = 0;

		CustomIterator() {
			setTmpArray();
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < tmp.size();
		}

		@Override
		public K next() {
			K val = (K) (tmp.get(index).key + "" + tmp.get(index).value);
			index++;
			return val;
		}

	}

	private int size;
	private LinkedList<HMNode>[] buckets; // N = buckets.length

	public HashTable() {
		initbuckets(4);
		size = 0;
	}

	private void initbuckets(int N) {
		buckets = new LinkedList[N];
		for (int bi = 0; bi < buckets.length; bi++) {
			buckets[bi] = new LinkedList<>();
		}
	}

	// insert
	public void insert(K key, V value) throws Exception {
		if(key==null || value==null)
		{
			System.out.println("null values are not allowed in hash map");
			return;
		}
		int bi = hashfn(key);
		int di = getIndexWithinBucket(key, bi);
		if (di != -1) // if it is already present then overwrite its value else add new node
		{
			HMNode node = buckets[bi].get(di);
			node.value = value;
		} else {
			HMNode node = new HMNode(key, value);
			buckets[bi].add(node);
			size++;
		}

		double lambda = size * 1.0 / buckets.length;
		if (lambda > 2.0) {
			rehash();
		}
	}

	private void rehash() throws Exception {
		LinkedList<HMNode>[] oba = buckets;
		initbuckets(oba.length * 2);
		size = 0;
		for (int i = 0; i < oba.length; i++) {
			for (HMNode node : oba[i]) {
				insert(node.key, node.value);
			}
		}
	}

	// return hash code
	private int hashfn(K key) {
		if (key == null) {
			System.out.println("key is null");
			return -1;
		}
		int hc = key.hashCode();
		return Math.abs(hc) % buckets.length;
	}

	// will check if current key is present in hashmap or not if yes then will
	// return its index else will return -1
	private int getIndexWithinBucket(K key, int bi) {
		int di = 0;
		for (HMNode node : buckets[bi]) {
			if (node.key.equals(key)) {
				return di;
			}
			di++;
		}
		return -1;
	}

	// delete
	public void delete(K key) {
		int bi = hashfn(key);
		int di = getIndexWithinBucket(key, bi);
		if (di != -1) {
			buckets[bi].remove(di);
			size--;
		} else {
			System.out.println("key not present");
			return;
		}
	}

	// contains will return true if value is present
	public boolean contains(K key) {
		int bi = hashfn(key);
		int di = getIndexWithinBucket(key, bi);
		if (di != -1) {
			System.out.println("key is present ");
			return true;
		} else {
			System.out.println("key is not present ");
			return false;
		}
	}

	// get value by key
	public V getValueByKey(K key) {
		int bi = hashfn(key);
		int di = getIndexWithinBucket(key, bi);
		if (di != -1) {
			HMNode node = buckets[bi].get(di);
			return node.value;
		} else {
			return null;
		}
	}

	// traverse print
	public void print() {
		for (int i = 0; i < buckets.length; i++) {
			for (HMNode node : buckets[i]) {
				System.out.println(node.key + " " + node.value);
			}
		}
	}

	// set tmp array
	private void setTmpArray() {
		for (int i = 0; i < buckets.length; i++) {
			for (HMNode node : buckets[i]) {
				tmp.add(node);
			}
		}
	}

	// size
	public int size() {
		return size;
	}

	// set key list will create new list of keys
	public LList<K> keyList() {
		LList<K> tmp = new LList<K>();
		for (int i = 0; i < buckets.length; i++) {
			for (HMNode node : buckets[i]) {
				tmp.insert(node.key);
			}
		}
		return tmp;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new CustomIterator<K>();
	}

}
