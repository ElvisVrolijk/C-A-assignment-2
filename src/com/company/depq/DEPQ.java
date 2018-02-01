package com.company.depq;

import java.util.ArrayList;

public class DEPQ<T> {

    private ArrayList queue;

    public DEPQ(ArrayList queue) {
        this.queue = queue;
    }

    public void add(T object, int priority) {
        insert(new DEPQItem<T>(priority, object));
    }

    public void insert(DEPQItem item) {

    }

    public DEPQItem<T> getMin() {

    }

    public DEPQItem<T> getMax() {

    }

    public void removeMin() {

    }

    public void removeMax() {

    }

    public int size() {
        return this.queue.size();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Helper methods
    ///////////////////////////////////////////////////////////////////////////
    private int priorityOf(DEPQItem item) {
        return item.getPriority();
    }

}
