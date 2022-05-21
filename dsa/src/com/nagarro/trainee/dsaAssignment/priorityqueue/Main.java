package com.nagarro.trainee.dsaAssignment.priorityqueue;

public class Main {

	public static void main(String[] args) throws Exception {
	 
		PriorityQueue list=new PriorityQueue();
		System.out.println(list.size());
		list.enqueue(10);
		list.enqueue(20);
		list.enqueue(30);
		list.enqueue(40);
		list.enqueue(50);
		list.enqueue(60);
		list.enqueue(70);
		list.enqueue(80);
		System.out.println(list.size());
		System.out.println(list.peek());
		System.out.println(list.size());
		System.out.println(list.peek());
		list.contains(30);
		list.print();
		list.enqueue(15);
		list.print();
		for(Integer itr: list)
		{
			System.out.println(itr);
		}
		list.reverse();
		list.print();
		
		

	}

}
