package com.nagarro.trainee.dsaAssignment.trees;

public class Main {
	public static void main(String args[]) throws Exception
    {
		Tree<Integer> tt=new Tree<Integer>();
	    System.out.println(tt.root);
	    tt.insert(null, 1); 
	    tt.insert(1, 2);
	    tt.insert(1, 3);
	    tt.insert(1, 4);
	    tt.insert(2, 5);
	    tt.insert(2, 6);
	    tt.insert(3, 7);
	    tt.insert(4, 8);
	    tt.insert(4, 9);
	    tt.getbyLevel();
	    tt.printBfs();
	    tt.delete(3);
	    tt.printBfs();
	    System.out.println(tt.contains(tt.root, 4));
	    System.out.println(tt.getByValue(4).data);
	    tt.printDfs(tt.root);
	    System.out.println();
	    for(Integer itr:tt)
	    {
	    	System.out.print(itr+" ");
	    }
    }

}
