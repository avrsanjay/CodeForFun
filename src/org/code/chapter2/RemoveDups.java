package org.code.chapter2;
/*
Remove Dups! Write code to remove duplicates from an unsorted linked list using a temporary buffer space
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node {
	int data;
	Node prev = null,next = null;
	public Node(int data) {
		this.data = data;
	}
}

class LinkList{
	public Node head,tail;
	
	public LinkList(){
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		return (this.head == null && this.tail == null)? true:false;
	}
	
	public void insert(int data) {
		Node current = new Node(data);
		
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
	
	public HashMap<Integer, Integer> deleteDups(Node current, HashMap<Integer,Integer> container) {
		if (current != null) {
			while (true) {
				if (container.containsKey(current.data) && (container.get(current.data) > 1)) {
					if (current.prev == null)
						if (current.next == null)
							this.head = this.tail = null;
						else {
							current.next.prev = null;
							this.head = current.next;
						}
					else if (current.next == null)
						if (current.prev == null)
							this.head = this.tail = null;
						else {
							current.prev.next = null;
							this.tail = current.prev;
						}
					else {
						current.prev.next = current.next;
						current.next.prev = current.prev;
					}
					container.put(current.data, (container.get(current.data)-1));
				}
				if (current.next != null)
					current = current.next;
				else
					break;
			}
		}
		else
			System.out.println("The linked list is empty!");
		return container;
	}
	
	public void printList() {
		if (this.head != null) {
			Node temp = this.head;
			while(true) {
				System.out.println(temp.data);
				temp = temp.next;
				if (temp == null)
					break;
			}
		}
	}
}

public class RemoveDups {
	public static void printMap(HashMap<Integer, Integer> container) {
		for (Map.Entry<Integer, Integer> entry : container.entrySet()) {
			System.out.println("Key: "+entry.getKey()+",  Value: "+entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the elements: (if finished, enter 'f')");
		
		LinkList mylist = new LinkList();
		HashMap<Integer,Integer> container = new HashMap<Integer, Integer>();
		while(true){
			String number = scanner.next();
			if (number.equals("f"))
				break;
			if (container.containsKey(Integer.parseInt(number))) {
				container.put(Integer.parseInt(number), container.get(Integer.parseInt(number))+1);
			} else {
				container.put(Integer.parseInt(number), 1);
			}
			mylist.insert(Integer.parseInt(number));
		} 
		scanner.close();
		System.out.println("Linked List:");
		System.out.println("------------");
		mylist.printList();
		System.out.println("HashMap items:");
		System.out.println("--------------");
		printMap(container);
		System.out.println();
		System.out.println("Deleting duplicates");
		container = mylist.deleteDups(mylist.head,container);
		System.out.println();
		System.out.println("Updated list:");
		System.out.println("-------------");
		mylist.printList();
		System.out.println("Updated HashMap:");
		System.out.println("----------------");
		printMap(container);
	}
}
