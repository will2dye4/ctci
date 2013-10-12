package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Question2_3_Test
{

    @Test
    public void solve_DeletesCorrectNode()
    {
        LinkedList<Character> list = setUpLinkedList();
        LinkedListNode<Character> nodeToDelete = list.getHead().getNext().getNext();
        new Question2_3<Character>(nodeToDelete).solve();
        assertNodeDataEquals('b', list.getHead().getNext());
        assertNodeDataEquals('d', list.getHead().getNext().getNext());
    }

    @Test(expected=IllegalArgumentException.class)
    public void solveWithLastNode_ThrowsException()
    {
        LinkedList<Character> list = new LinkedList<Character>('a');
        new Question2_3<Character>(list.getHead()).solve();
    }

    private LinkedList<Character> setUpLinkedList()
    {
        LinkedList<Character> list = new LinkedList<Character>('a');
        list.appendToTail('b');
        list.appendToTail('c');
        list.appendToTail('d');
        list.appendToTail('e');
        return list;
    }

    private void assertNodeDataEquals(char expected, LinkedListNode<Character> actual)
    {
        assertEquals(expected, (char)actual.getData());
    }

}
