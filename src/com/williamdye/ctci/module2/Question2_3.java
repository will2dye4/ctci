package com.williamdye.ctci.module2;

import com.williamdye.ctci.AbstractQuestion;
import com.williamdye.ctci.util.LinkedListNode;

/**
 * TASK:
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 *
 * EXAMPLE:
 * Input: the node c from the linked list a -> b -> c -> d -> e
 * Result: nothing is returned, but the new linked list looks like a -> b -> d -> e
 */
public class Question2_3<T> extends AbstractQuestion
{

    private LinkedListNode<T> nodeToDelete;

    public Question2_3(LinkedListNode<T> node)
    {
        if (node.getNext() == null)
            throw new IllegalArgumentException("node to delete cannot be the last node in the list");
        this.nodeToDelete = node;
    }

    @Override
    public void solve()
    {
        LinkedListNode<T> next = nodeToDelete.getNext();
        nodeToDelete.setData(next.getData());
        nodeToDelete.setNext(next.getNext());
    }

}
