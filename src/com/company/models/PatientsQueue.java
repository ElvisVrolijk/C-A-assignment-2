package com.company.models;

import com.company.depq.DEPQ;

public class PatientsQueue {
    private DEPQ<Patient> queue;

    public PatientsQueue() {
        //INIT: Double Ended Priority Queue
        queue = new DEPQ<>();
    }

    public void add(Patient patient, int priority) {
        queue.add(patient, priority);
    }

    public Patient getOneWithMaxPriority() {
        return this.queue.getMin().getValue();
    }

    public Patient getOneWithMinPriority() {
        return this.queue.getMax().getValue();
    }

    public void removeOneWithMaxPriority() {
        this.queue.removeMax();
    }

    public void removeOneWithMinPriority() {
        this.queue.removeMin();
    }

    public boolean isEmpty() {
        return size() > 0;
    }

    public int size() {
        return this.queue.size();
    }

}
