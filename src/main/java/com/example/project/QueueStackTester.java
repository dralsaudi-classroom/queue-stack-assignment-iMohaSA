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
    LinkedPQ<T> tmp = new LinkedPQ<>();
    int len = pq.length();

    for (int i = 0; i < len; i++) {
        PQElement<T> element = pq.serve();
        int priority = element.getPriority();
        
        if (priority >= p) {
            tmp.enqueue(element.getItem(), priority);
        }
    }

    while (tmp.length() > 0) {
        PQElement<T> element = tmp.serve();
        pq.enqueue(element.getItem(), element.getPriority());
    }
}

  public static <T> boolean search(LinkedPQ<T> st, T e) {
    if (st.length() == 0) {
        return false;
    }

    T top = st.serve();

    if (top.equals(e)) {
        st.enqueue(top, 0);
        return true;
    }

    boolean found = search(st, e);

    st.enqueue(top, 0);

    return found;
}
