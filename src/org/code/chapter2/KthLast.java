package org.code.chapter2;

import java.util.HashMap;
import java.util.Scanner;

class Node3 {
	int data;
	Node3 prev = null,next = null;
	public Node3(int data) {
		this.data = data;
	}
}

class LinkList3{
	public Node3 head,tail;
	
	public LinkList3(){
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		return (this.head == null && this.tail == null)? true:false;
	}
	
	public void insert(int data) {
		Node3 current = new Node3(data);
		
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
	

	public void printList() {
		if (this.head != null) {
			Node3 temp = this.head;
			while(true) {
				System.out.println(temp.data);
				temp = temp.next;
				if (temp == null)
					break;
			}
		}
	}

	public int findElement(Node3 head, int k) {
		if (head != null) {
			Node3 head2 = head.next;
			int count = 1;
			while(head2 != null) {
				if (count == k)
					break;
				head2 = head2.next;
				count++;
			}
			while (head2 != null) {
				head = head.next;
				head2 = head2.next;
			}
			return head.data;
		}
		else
			return -1;
	}
}

public class KthLast {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the elements: (if finished, enter 'f')");
		
		LinkList3 mylist = new LinkList3();
		while(true){
			String number = scanner.next();
			if (number.equals("f"))
				break;
			mylist.insert(Integer.parseInt(number));
		}
		System.out.println("Linked List:");
		System.out.println("------------");
		mylist.printList();
		System.out.println("Enter which element you want from last:");
		int k = scanner.nextInt();
		scanner.close();
		System.out.println("The Kth element to the last is "+mylist.findElement(mylist.head, k));
	}

}
