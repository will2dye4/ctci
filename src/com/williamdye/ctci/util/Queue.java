package com.williamdye.ctci.util;

public class Queue<T>
{

    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    public Queue()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Queue(T data)
    {
        this();
        enqueue(data);
    }

    public void enqueue(T data)
    {
        LinkedListNode<T> newTail = new LinkedListNode<T>(data);
        if (size == 0)
            head = newTail;
        else
            tail.setNext(newTail);
        tail = newTail;
        size += 1;
    }

    public T dequeue()
    {
        if (head == null)
            return null;
        T data = head.getData();
        head = head.getNext();
        if (size == 1)
            tail = null;
        size -= 1;
        return data;
    }

    public int getSize()
    {
        return this.size;
    }

}
