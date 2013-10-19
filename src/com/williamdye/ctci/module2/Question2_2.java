package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;

/**
 * TASK:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class Question2_2<T> extends AbstractLinkedListQuestion<T>
{

    private int k;
    private LinkedListNode<T> kthToLastNode;

    public Question2_2(LinkedList<T> list, int k)
    {
        super(list);
        if (k <= 0)
            throw new IllegalArgumentException("k must be greater than or equal to 1");
        if (k > list.getSize())
            throw new IllegalArgumentException("k must be less than or equal to the number of nodes in the list");
        this.k = k;
        this.kthToLastNode = null;
    }

    @Override
    public void solve()
    {
        findKthToLastNode();
    }

    private void findKthToLastNode()
    {
        int count = list.getSize() - k;
        LinkedListNode<T> current = list.getHead();
        while (count > 0) {
            current = current.getNext();
            count -= 1;
        }
        this.kthToLastNode = current;
    }

    public LinkedListNode<T> getKthToLastNode()
    {
        return this.kthToLastNode;
    }

}
