package com.williamdye.ctci.util;

public class Stack<T>
{

    private LinkedListNode<T> top;
    private int size;

    public Stack()
    {
        this.top = null;
        this.size = 0;
    }

    public Stack(T data)
    {
        this();
        push(data);
    }

    public void push(T data)
    {
        LinkedListNode<T> newHead = new LinkedListNode<T>(data);
        if (size > 0)
            newHead.setNext(top);
        top = newHead;
        size += 1;
    }

    public T pop()
    {
        if (size == 0)
            return null;
        T data = top.getData();
        top = top.getNext();
        size -= 1;
        return data;
    }

    public T peek()
    {
        if (size == 0)
            return null;
        return top.getData();
    }

    public int getSize()
    {
        return this.size;
    }

}
