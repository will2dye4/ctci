package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.LinkedList;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Question2_2_Test
{

    private static LinkedList<Integer> list;

    private Question2_2<Integer> question;

    @BeforeClass
    public static void setUpLinkedList()
    {
        list = new LinkedList<Integer>(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(5);
        list.appendToTail(6);
        list.appendToTail(7);
        list.appendToTail(8);
        list.appendToTail(9);
    }

    @Test
    public void solve_ReturnsCorrectNode()
    {
        solveWithValueOfK(1);
        assertKthToLastNodeDataEquals(9);
        solveWithValueOfK(2);
        assertKthToLastNodeDataEquals(8);
        solveWithValueOfK(5);
        assertKthToLastNodeDataEquals(5);
        solveWithValueOfK(8);
        assertKthToLastNodeDataEquals(2);
        solveWithValueOfK(9);
        assertKthToLastNodeDataEquals(1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void solveWithZero_ThrowsException()
    {
        solveWithValueOfK(0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void solveWithNegativeK_ThrowsException()
    {
        solveWithValueOfK(-1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void solveWithTooLargeK_ThrowsException()
    {
        solveWithValueOfK(10);
    }

    private void solveWithValueOfK(int k)
    {
        question = new Question2_2<Integer>(list, k);
        question.solve();
    }

    private void assertKthToLastNodeDataEquals(int expected)
    {
        assertEquals(expected, (int)question.getKthToLastNode().getData());
    }

}
