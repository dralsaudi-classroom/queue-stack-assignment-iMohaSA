package com.example.project;

public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> current;
	
    public LinkedList() {
		head = current = null;
	}
	public boolean empty() {
		return head == null;
	}
	public boolean last() {
		return current.next == null;
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
    public T retrieve() {
        return current.data;
    }
    public void update(T e) {
        current.data = e;
    }
    public void insert(T e) {
        if (empty()) {
            current = head = new Node<T>(e);
        } else {
            Node<T> tmp = current.next;
            current.next = new Node<T>(e);
            current = current.next;
            current.next = tmp;
        }
    }
    public void remove() {
        if (current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while (tmp.next != current) {
                tmp = tmp.next;
            }
            tmp.next = current.next;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    }
	public T mostFrequentElement() {
	    if (head == null) {
	        return null;
	    }
	
	    Node<T> tmp = head;
	    T mostFrequent = null;
	    int maxCount = 0;
	
	    while (tmp != null) {
	        T currentElement = tmp.data;
	        int count = 0;
	        Node<T> runner = head;
	
	        while (runner != null) {
	            if (runner.data.equals(currentElement)) {
	                count++;
	            }
	            runner = runner.next;
	        }
	
	        if (count > maxCount) {
	            maxCount = count;
	            mostFrequent = currentElement;
	        }
	
	        tmp = tmp.next;
	    }
	
	    return mostFrequent;
	}


        //         Write the method mostFrequentElement, member of the class LinkedList, that returns
        // the most frequent element in the list. The most frequent element is the element
        // appearing the highest number of times. If one or more element appear the same
        // number of times, the one encountered earlier is returned.
        // Example 1.1. Given the list l : A, B, C, B, C, D, E, mostFrequentElement() returns
        // B.
}
