package com.williamdye.ctci.module3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Question3_3_Test
{

    private Question3_3<Integer> question;

    @Test
    public void pushAndPop_WorkAsUsual()
    {
        question = new Question3_3<Integer>(2);

        question.push(1);
        question.push(2);
        assertPopDataEquals(2);

        question.push(3);
        question.push(4); /* new stack is created */
        assertPopDataEquals(4);
        assertPopDataEquals(3);

        question.push(5);
        question.push(6);
        question.push(7);
        question.push(8);
        assertPopDataEquals(8);
        assertPopDataEquals(7);
        assertPopDataEquals(6);
        assertPopDataEquals(5);
        assertPopDataEquals(1);

        assertNull(question.pop());
    }

    @Test
    public void peek_WorksAsUsual()
    {
        question = new Question3_3<Integer>(2);

        question.push(1);
        assertPeekDataEquals(1);
        assertPeekDataEquals(1);

        question.push(2);
        question.push(3);
        question.push(4);
        assertPeekDataEquals(4);

        question.pop();
        assertPeekDataEquals(3);
        question.pop();
        assertPeekDataEquals(2);
        question.pop();
        assertPeekDataEquals(1);
        question.pop();

        assertNull(question.peek());
    }

    private void assertPopDataEquals(int expected)
    {
        assertStackDataEquals(expected, question.pop());
    }

    private void assertPeekDataEquals(int expected)
    {
        assertStackDataEquals(expected, question.peek());
    }

    private void assertStackDataEquals(int expected, int actual)
    {
        assertEquals(expected, actual);
    }

}
