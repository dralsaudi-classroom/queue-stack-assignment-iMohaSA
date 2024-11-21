package com.example.project;

public class QueueStackTester {

    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq) {
        int count = q.length();
        recSplit(q, oq, eq, count, 1);
    }

    private static <T> void recSplit(Queue<T> q, Queue<T> oq, Queue<T> eq, int count, int pos) {
        if (pos > count) {
            return;
        }
        T element = q.serve();

        q.enqueue(element);


        if (pos % 2 == 1) {
            oq.enqueue(element);
        } else {
            eq.enqueue(element);
        }


        recSplit(q, oq, eq, count, pos + 1);
    }


    public static <T> void remove(LinkedPQ<T> pq, int p) {
        LinkedPQ<T> tempPQ = new LinkedPQ<T>();
        int count = pq.length();


        for (int i = 0; i < count; i++) {
            PQElement<T> element = pq.serve();


            if (element.p >= p) {
                tempPQ.enqueue(element.data, element.p);
            }
        }


        count = tempPQ.length();
        for (int i = 0; i < count; i++) {
            PQElement<T> element = tempPQ.serve();
            pq.enqueue(element.data, element.p);
        }
    }





    public static <T> boolean search(Stack<T> st, T e) {
        if (st.empty()) return false;

        T element = st.pop();
        if (element.equals(e)) {
            st.push(element);
            return true;
        }

        boolean found = search(st, e);
        st.push(element);
        return found;
    }
}
