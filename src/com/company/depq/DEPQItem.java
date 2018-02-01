package com.company.depq;

public class DEPQItem<T> implements IPrioritizedItem{

    private int priority;
    private T value;

    public DEPQItem(int priority, T value) {
        this.priority = priority;
        this.value = value;
    }

    public T getValue() {
        return (T)value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
