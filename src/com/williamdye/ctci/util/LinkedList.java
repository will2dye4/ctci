package com.williamdye.ctci.util;

public class LinkedList<T>
{

    private LinkedListNode<T> head;

    public LinkedList(T data)
    {
        this.head = new LinkedListNode<T>(data);
    }

    public LinkedListNode<T> getHead()
    {
        return this.head;
    }

    public void appendToTail(T data)
    {
        LinkedListNode<T> node = this.head;
        while (node.getNext() != null)
            node = node.getNext();
        node.setNext(new LinkedListNode<T>(data));
    }

    public void removeNode(LinkedListNode<T> node)
    {
        LinkedListNode<T> current = this.head;
        LinkedListNode<T> previous = current;
        while (!(current.equals(node)) && (current.getNext() != null)) {
            previous = current;
            current = current.getNext();
        }
        if (current.equals(node))
            previous.setNext(current.getNext());
    }

}
