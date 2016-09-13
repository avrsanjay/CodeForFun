package org.code.chapter2;
/*
Remove Dups! Write code to remove duplicates from an unsorted linked list without a temporary buffer space
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node2 {
	int data;
	Node2 prev = null,next = null;
	public Node2(int data) {
		this.data = data;
	}
}

class LinkList2 {
	public Node2 head,tail;
	
	public LinkList2() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		return (this.head == null && this.tail == null)? true:false;
	}
	
	public void insert(int data) {
		Node2 current = new Node2(data);
		
		if (this.head == null && this.tail == null) {
			this.head = current;
			this.tail = current;
		} else if (this.head == this.tail) {
			current.prev = this.head;
			this.head.next = current;
			this.tail = current;
		} else if (this.head != null && this.tail != null) {
			current.prev = this.tail;
			this.tail.next = current;
			this.tail = current;
		}	
	}
	
	public void deleteDups(Node2 current) {
		while(current != null) {
			Node2 index = current.next;
			while(index != null) {
				if(index.data == current.data) {
					//write code for delete
					if (index.prev == null)
						if (index.next == null)
							this.head = this.tail = null;
						else {
							index.next.prev = null;
							this.head = index.next;
						}
					else if (index.next == null)
						if (index.prev == null)
							this.head = this.tail = null;
						else {
							index.prev.next = null;
							this.tail = index.prev;
						}
					else {
						index.prev.next = index.next;
						index.next.prev = index.prev;
					}
				}
				if (index.next == null)
					break;
				else
					index = index.next;
			}
			if (current.next == null)
				break;
			else
				current = current.next;
		}
	}
	
	public void printList() {
		if (this.head != null) {
			Node2 temp = this.head;
			while(true) {
				System.out.println(temp.data);
				temp = temp.next;
				if (temp == null)
					break;
			}
		}
	}
}

public class RemoveDups2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the elements: (if finished, enter 'f')");
		
		LinkList2 mylist = new LinkList2();
		HashMap<Integer,Integer> container = new HashMap<Integer, Integer>();
		while(true){
			String number = scanner.next();
			if (number.equals("f"))
				break;
			mylist.insert(Integer.parseInt(number));
		}
		scanner.close();
		System.out.println();
		System.out.println("Linked List:");
		System.out.println("------------");
		mylist.printList();
		System.out.println();
		System.out.println("**************Deleting duplicates**************");
		mylist.deleteDups(mylist.head);
		System.out.println();
		System.out.println("Updated list:");
		System.out.println("-------------");
		mylist.printList();
	}
}
