package com.example.project;

public class QueueStackTester {
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq) {
    if (q.length() == 0) {
        return;
    }

    T e1 = q.serve();
    oq.enqueue(e1);

    if (q.length() > 0) {
        T e2 = q.serve();
        eq.enqueue(e2);
    }

    split(q, oq, eq);

    oq.enqueue(e1);
    if (q.length() > 0) {
        eq.enqueue(q.serve());
    }
}


public static <T> void remove(LinkedPQ<T> pq, int p) {
        LinkedPQ<T> tmp = new LinkedPQ<>(); // Temporary queue to hold items with priority >= p

        // Process all elements in the input priority queue
        while (pq.length() > 0) {
            PQElement<T> element = pq.serve(); // Retrieve the element with the highest priority
            if (element.p >= p) {             // Check if the priority meets the threshold
                tmp.enqueue(element.data, element.p); // Keep elements with priority >= p
            }
        }

        // Rebuild the original priority queue from the temporary queue
        while (tmp.length() > 0) {
            PQElement<T> element = tmp.serve(); // Retrieve the next element from tmp
            pq.enqueue(element.data, element.p); // Reinsert into the original queue
        }
    }


    public static <T> boolean search(LinkedPQ<T> pq, T e) {
        LinkedPQ<T> temp = new LinkedPQ<>(); // Temporary queue to hold elements during the search
        boolean found = false;

        // Traverse the priority queue
        while (pq.length() > 0) {
            PQElement<T> element = pq.serve(); // Retrieve the top element
            if (element.data.equals(e)) {
                found = true; // Element found
            }
            temp.enqueue(element.data, element.p); // Save the element in the temp queue
        }

        // Restore the original priority queue
        while (temp.length() > 0) {
            PQElement<T> element = temp.serve();
            pq.enqueue(element.data, element.p);
        }

        return found;
    }
}
