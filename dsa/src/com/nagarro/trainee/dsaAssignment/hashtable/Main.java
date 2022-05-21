package com.nagarro.trainee.dsaAssignment.hashtable;

import com.nagarro.trainee.dsaAssignment.linkedlist.LList;

public class Main {
         public static void main(String args[]) throws Exception
         {
        	 HashTable<String,Integer> hc=new HashTable<String,Integer>();
     		System.out.println(hc.size());
     		hc.insert("india", 140);
     		hc.insert("usa", 35);
     		hc.insert("china", 150);
     		hc.insert("pakistan", 25);
     		hc.insert("eu", 60);
     		hc.insert(null, null);
     		System.out.println(hc.size());
     		hc.delete("pakistan");
     		hc.contains("india");
     		System.out.println(hc.getValueByKey("india"));
     		hc.print();
     		LList<String> ll=hc.keyList();  // to store keys of hash table in list 
     		for(String itr: ll) {
     			System.out.println(itr+" "+hc.getValueByKey(itr));
     		}
     		
     		
         }
}
