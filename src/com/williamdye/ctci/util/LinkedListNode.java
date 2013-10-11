package com.williamdye.ctci.util;

public class LinkedListNode<T>
{

    private LinkedListNode<T> next;
    private T data;

    public LinkedListNode(T data)
    {
        this.next = null;
        this.data = data;
    }

    public LinkedListNode<T> getNext()
    {
        return this.next;
    }

    public void setNext(LinkedListNode<T> next)
    {
        this.next = next;
    }

    public T getData()
    {
        return this.data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

}
