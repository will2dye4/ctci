package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.Digit;
import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Question2_5_Test
{

    private LinkedListNode<Digit> node;

    @Test
    public void solve_ReturnsCorrectSum()
    {
        LinkedList<Digit> firstNumber = setUpLinkedList(7, 1, 6);
        LinkedList<Digit> secondNumber = setUpLinkedList(5, 9, 2);

        Question2_5 question = new Question2_5(firstNumber, secondNumber);
        question.solve();

        LinkedList<Digit> sum = question.getSum();
        node = sum.getHead();

        assertNodeDataEqualsAndAdvanceNode(2);
        assertNodeDataEqualsAndAdvanceNode(1);
        assertNodeDataEqualsAndAdvanceNode(9);
        assertNull(node);
    }

    private LinkedList<Digit> setUpLinkedList(Integer... digits)
    {
        LinkedList<Digit> list = new LinkedList<Digit>(new Digit(digits[0]));
        for (int i = 1; i < digits.length; i++)
            list.appendToTail(new Digit(digits[i]));
        return list;
    }

    private void assertNodeDataEqualsAndAdvanceNode(int expected)
    {
        assertEquals(expected, node.getData().intValue());
        node = node.getNext();
    }

}
