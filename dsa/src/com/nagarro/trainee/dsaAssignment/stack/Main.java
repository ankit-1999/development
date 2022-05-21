package com.nagarro.trainee.dsaAssignment.stack;

public class Main {
	public static void main(String args[])
    {
		Stack<Integer> st=new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		System.out.println("peek element of stack is : "+st.peek());
		st.pop();
		System.out.println("size of stack is : " + st.size);
		if(st.contains(2))
		{
			System.out.println("element is present");
		}
		else {
			System.out.println("element is not present");
		}
		System.out.println(st.size());
		st.print();
		st.reverse();
		System.out.println("stack after reverse");
		st.print();
		// printing using iterator
		for(Integer itr:st)
		{
			System.out.println(itr);
		}
		
    }

}
