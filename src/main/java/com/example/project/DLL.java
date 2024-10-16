package com.example.project;

public class DLL<T> {
	private DLLNode<T> head;
	private DLLNode<T> current;

    public DLL() {
        head = current = null;
    }
    public boolean empty() {
        return head == null;
    }
    public boolean last() {
        return current.next == null;
    }
    public boolean first() {
        return current.previous == null;
    }
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public void findPrevious() {
        current = current.previous;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T val) {
        current.data = val;
    }
    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<T>(val);
        if(empty()) {
            current = head = tmp;
        }
        else {
            tmp.next = current.next;
            tmp.previous = current;
            if(current.next != null)
                current.next.previous = tmp;
            current.next = tmp;
            current = tmp;
        }
    }
    public void remove() {
        if(current == head) {
            head = head.next;
            if(head != null)
               head.previous = null;
        }
        else {
            current.previous.next = current.next;
            if(current.next != null)
               current.next.previous = current.previous;
        }
        if(current.next == null)
            current = head;
        else
            current = current.next;
    }
    public void removeBetween(T e1, T e2) {
	    Node<T> tmpe1 = head;
	    Node<T> tmpe2;
	
	    while (tmpe1 != null && !tmpe1.data.equals(e1)) {
	        tmpe1 = tmpe1.next;
	    }
	    if(tmpe1 == null)
		    return;
	    
	    tmpe2 = tmpe1.next;
	
	    while (tmpe2 != null && !tmpe2.data.equals(e2)) {
	        tmpe2 = tmpe2.next;
	    }
	
	    if (tmpe2 == null) {
	        return;
	    }
	
	   tmpe1.next = tmpe2;
	    tmpe2.previous = tmpe1;

        // Write the method removeBetween, member of the class DoubleLinkedList. The method
        // takes two elements e1 and e2, and removes all the elements between the two elements
        // (e1 and e2 not included). If e1 or e2 or both doesn’t exist, no element will be removed. You can assume the elements to be unique, e1 comes before e2, and that
        // e1 ̸= e2. Current is moved to head if the removal is successful. Do not call any
        // methods and do not use any auxiliary data structures. The method signature
        // is: public void removeBetween(T e1, T e2).
        // Example 3.1. Given the list: A ↔ B ↔ C ↔ D ↔ E ↔ F, removeBetween(’B’,
        // ’E’) results in: A ↔ B ↔ E ↔ F.
    }
}
