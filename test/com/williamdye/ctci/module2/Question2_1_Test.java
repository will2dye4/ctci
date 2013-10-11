package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Question2_1_Test
{

    private LinkedListNode<Integer> node;

    @Test
    public void solve_RemovesDuplicateNodes()
    {
        LinkedList<Integer> list = setUpLinkedList();
        new Question2_1(list).solve();

        node = list.getHead();
        assertNodeDataEqualsAndAdvanceNode(1);
        assertNodeDataEqualsAndAdvanceNode(2);
        assertNodeDataEqualsAndAdvanceNode(3);
        assertNodeDataEqualsAndAdvanceNode(4);
        assertNodeDataEqualsAndAdvanceNode(5);
        assertNodeDataEqualsAndAdvanceNode(6);
        assertNull(node);
    }

    private LinkedList<Integer> setUpLinkedList()
    {
        LinkedList<Integer> list = new LinkedList<Integer>(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(5);
        list.appendToTail(1);
        list.appendToTail(6);
        list.appendToTail(3);
        list.appendToTail(5);
        return list;
    }

    private void assertNodeDataEqualsAndAdvanceNode(int expected)
    {
        assertEquals(expected, (int)node.getData());
        node = node.getNext();
    }

}
