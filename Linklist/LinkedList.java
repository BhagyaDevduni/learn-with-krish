//Q1. Write a program to reverse a singular linked list without using a second data structure.

//Q2. Find if a given linked list is a palindrome or not.

package com.Linklist;

public class LinkedList {
	
		Node head; // head of list
	    Node slow_ptr, fast_ptr, second_half;
	  
	  
	    class Node {
	        char data;
	        Node next;
	  
	        Node(char d)
	        {
	            data = d;
	            next = null;
	        }
	    }
	  
	    //to check if given linked list is palindrome or not 
	    boolean isPalindrome(Node head)
	    {
	        slow_ptr = head;
	        fast_ptr = head;
	        Node prev_of_slow_ptr = head;
	        Node midnode = null; // To handle odd size list
	        boolean res = true; // initialize result
	  
	        if (head != null && head.next != null) {
	            
	            while (fast_ptr != null && fast_ptr.next != null) {
	                fast_ptr = fast_ptr.next.next;
	  
	               
	                prev_of_slow_ptr = slow_ptr;
	                slow_ptr = slow_ptr.next;
	            }
	  
	            
	            if (fast_ptr != null) {
	                midnode = slow_ptr;
	                slow_ptr = slow_ptr.next;
	            }
	  
	            // Now reverse the second half and compare it with first half
	            second_half = slow_ptr;
	            prev_of_slow_ptr.next = null; // NULL terminate first half
	            reverse(); // Reverse the second half
	            res = compareLists(head, second_half); // compare
	  
	          
	            reverse(); // Reverse the second half again
	  
	            if (midnode != null) {
	                // If there was a mid node (odd size case) which
	                // was not part of either first half or second half.
	                prev_of_slow_ptr.next = midnode;
	                midnode.next = second_half;
	            }
	            else
	                prev_of_slow_ptr.next = second_half;
	        }
	        return res;
	    }
	  
	    // reverse the linked list  Note that this may change the head 
	    void reverse()
	    {
	        Node prev = null;
	        Node current = second_half;
	        Node next;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        second_half = prev;
	    }
	  
	    //check if two input lists have same data
	    boolean compareLists(Node head1, Node head2)
	    {
	        Node temp1 = head1;
	        Node temp2 = head2;
	  
	        while (temp1 != null && temp2 != null) {
	            if (temp1.data == temp2.data) {
	                temp1 = temp1.next;
	                temp2 = temp2.next;
	            }
	            else
	                return false;
	        }
	  
	      
	        if (temp1 == null && temp2 == null)
	            return true;
	  
	      
	        return false;
	    }
	  
	    
	    public void push(char new_data)
	    {
	       
	        Node new_node = new Node(new_data);
	  
	        
	        new_node.next = head;
	  
	       
	        head = new_node;
	    }
	  
	    //  print a given linked list
	    void printList(Node ptr)
	    {
	        while (ptr != null) {
	            System.out.print(ptr.data + "->");
	            ptr = ptr.next;
	        }
	        System.out.println("NULL");
	    }
	  
	   
	    public static void main(String[] args)
	    {
	  
	        /* Start with the empty list */
	        LinkedList llist = new LinkedList();
	  
	        char str[] = { 'R', 'A', 'C', 'E' ,'C','A','R' };
	        String string = new String(str);
	        for (int i = 0; i < 7; i++) {
	            llist.push(str[i]);
	            llist.printList(llist.head);
	            if (llist.isPalindrome(llist.head) != false) {
	                System.out.println("Is Palindrome");
	                System.out.println("");
	            }
	            else {
	                System.out.println("Not Palindrome");
	                System.out.println("");
	            }
	        }
	    }

}
