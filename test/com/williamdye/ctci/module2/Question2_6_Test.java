package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Question2_6_Test
{

    @Test
    public void solveWithCircularList_ReturnsCorrectNode()
    {
        LinkedList<Character> list = setUpCircularLinkedList();
        LinkedListNode<Character> loopNode = list.getHead().getNext().getNext();
        Question2_6<Character> question = new Question2_6<Character>(list);
        question.solve();
        assertEquals(loopNode, question.getLoopNode());
    }

    @Test
    public void solveWithNormalLinkedList_ReturnsNull()
    {
        LinkedList<Character> list = setUpNormalLinkedList();
        Question2_6<Character> question = new Question2_6<Character>(list);
        question.solve();
        assertNull(question.getLoopNode());
    }

    private LinkedList<Character> setUpCircularLinkedList()
    {
        return setUpLinkedList(true);
    }

    private LinkedList<Character> setUpNormalLinkedList()
    {
        return setUpLinkedList(false);
    }

    private LinkedList<Character> setUpLinkedList(boolean circular)
    {
        LinkedList<Character> list = new LinkedList<Character>('A');
        list.appendToTail('B');
        list.appendToTail('C');
        list.appendToTail('D');
        list.appendToTail('E');
        if (circular) {
            LinkedListNode<Character> cNode = list.getHead().getNext().getNext();
            LinkedListNode<Character> eNode = cNode.getNext().getNext();
            eNode.setNext(cNode);
        }
        return list;
    }

}
