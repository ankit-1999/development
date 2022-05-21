package com.nagarro.trainee.dsaAssignment.linkedlist;

public class Main {
	public static void main(String args[])
    {
		LList<Integer> list = new LList<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insertAtPosition(6, 4);
		list.insertAtPosition(5, 4);
		list.insertAtPosition(4, 4);
		System.out.println("size of list is " + list.size());
		list.print();
		list.delete(2);
		// list.delete(1);
	    list.deleteAtPosition(3);
		list.print();
	    System.out.println("center of list is " + list.center());
	    list.reverse();
	    System.out.println("linked list after reverse ");
	    list.print();
	    
	    // printing using iterator 
	    for(Integer itr:list)
	    {
	    	System.out.println(itr);
	    }
    }

}
