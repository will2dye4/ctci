package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Question2_4_Test
{

    @Test
    public void solveWithSingletonList_DoesNothing()
    {
        LinkedList<Integer> singleton = new LinkedList<Integer>(1);
        LinkedListNode<Integer> originalHead = singleton.getHead();
        new Question2_4<Integer>(singleton, 4).solve();
        assertEquals(originalHead, singleton.getHead());
    }

    @Test
    public void solveWithPartitionableList_PartitionsCorrectly()
    {
        LinkedList<Integer> list = setUpLinkedList();
        new Question2_4<Integer>(list, 5).solve();
        assertNodeOrderIs(list, 2, 1, 4, 3, 7, 9, 8, 6);
    }

    @Test
    public void solveWithAllItemsGreater_PartitionsCorrectly()
    {
        LinkedList<Integer> list = setUpLinkedList();
        new Question2_4<Integer>(list, 0).solve();
        assertNodeOrderIs(list, 2, 7, 1, 9, 4, 8, 3, 6);
    }

    @Test
    public void solveWithAllItemsLess_PartitionsCorrectly()
    {
        LinkedList<Integer> list = setUpLinkedList();
        new Question2_4<Integer>(list, 10).solve();
        assertNodeOrderIs(list, 2, 7, 1, 9, 4, 8, 3, 6);
    }

    private LinkedList<Integer> setUpLinkedList()
    {
        LinkedList<Integer> list = new LinkedList<Integer>(2);
        list.appendToTail(7);
        list.appendToTail(1);
        list.appendToTail(9);
        list.appendToTail(4);
        list.appendToTail(8);
        list.appendToTail(3);
        list.appendToTail(6);
        return list;
    }

    private void assertNodeOrderIs(LinkedList<Integer> list, Integer... values)
    {
        LinkedListNode<Integer> current = list.getHead();
        for (Integer expected : values) {
            assertEquals(expected, current.getData());
            current = current.getNext();
        }
        assertNull(current);
    }

}
