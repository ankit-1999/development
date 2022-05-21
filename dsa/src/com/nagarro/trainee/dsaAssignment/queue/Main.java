package com.nagarro.trainee.dsaAssignment.queue;

public class Main {
	public static void main(String args[])
    {
		Queue<Integer> q=new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.front.data +"+"+q.back.data);
		q.dequeue();
		System.out.println(q.front.data +"+"+q.back.data);
		System.out.println(q.peek());
		System.out.println(q.size());
		q.print();
		q.reverse();
		System.out.println("queue after reverse");
		q.print();
		// printing using custom iterator
		for(Integer itr:q)
		{
			System.out.println(itr);
		}
   	 
    }

}
