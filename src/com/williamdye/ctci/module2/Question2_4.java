package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;

/**
 * TASK:
 * Write code to partition a linked list around a value x, such that all nodes less than x
 * come before all nodes greater than or equal to x.
 */
public class Question2_4<T extends Comparable<T>> extends AbstractLinkedListQuestion<T>
{

    private T x;
    private LinkedList<T> lessThan;
    private LinkedList<T> greaterThan;
    private LinkedListNode<T> current;

    public Question2_4(LinkedList<T> list, T x)
    {
        super(list);
        this.x = x;
        this.lessThan = null;
        this.greaterThan = null;
        this.current = list.getHead();
    }

    @Override
    public void solve()
    {
        if (list.getSize() < 2)
            return;

        partitionList();
        mergeLists();
        list.setHead(lessThan.getHead());
    }

    private void partitionList()
    {
        while (current != null) {
            appendCurrentToAppropriateList();
            current = current.getNext();
        }
    }

    private void appendCurrentToAppropriateList()
    {
        if (currentIsLessThanOrEqualToX())
            lessThan = appendCurrentToList(lessThan);
        else
            greaterThan = appendCurrentToList(greaterThan);
    }

    private boolean currentIsLessThanOrEqualToX()
    {
        return current.getData().compareTo(x) <= 0;
    }

    private LinkedList<T> appendCurrentToList(LinkedList<T> listToAppend)
    {
        if (listToAppend == null)
            listToAppend = new LinkedList<T>(current.getData());
        else
            listToAppend.appendToTail(current.getData());
        return listToAppend;
    }

    private void mergeLists()
    {
        if (lessThan == null) {
            lessThan = greaterThan;
        } else if (greaterThan != null) {
            LinkedListNode<T> lessThanTail = getTailOfLessThanList();
            lessThanTail.setNext(greaterThan.getHead());
        }
    }

    private LinkedListNode<T> getTailOfLessThanList()
    {
        LinkedListNode<T> tail = lessThan.getHead();
        while (tail.getNext() != null)
            tail = tail.getNext();
        return tail;
    }

}
