package com.williamdye.ctci.module2;

import com.williamdye.ctci.Question;
import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TASK:
 * Write code to remove duplicates from an unsorted linked list.
 *
 * FOLLOW UP:
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class Question2_1 implements Question
{

    private LinkedList<Integer> list;
    private Set<Integer> buffer;

    public Question2_1(LinkedList<Integer> list)
    {
        this.list = list;
        this.buffer = new LinkedHashSet<Integer>();
    }

    @Override
    public void solve()
    {
        LinkedListNode<Integer> node = list.getHead();
        while (node != null) {
            checkForDuplicate(node);
            node = node.getNext();
        }
    }

    private void checkForDuplicate(LinkedListNode<Integer> node)
    {
        if (buffer.contains(node.getData()))
            list.removeNode(node);
        else
            buffer.add(node.getData());
    }

}
