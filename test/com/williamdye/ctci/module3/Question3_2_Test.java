package com.williamdye.ctci.module3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Question3_2_Test
{

    private Question3_2<Integer> question;

    @Test
    public void pushAndPop_WorkAsUsual()
    {
        question = new Question3_2<Integer>();
        assertNull(question.pop());

        question.push(5);
        question.push(50);
        assertPopDataEquals(50);

        question.push(500);
        assertPopDataEquals(500);
        assertPopDataEquals(5);

        question.push(5000);
        assertPopDataEquals(5000);

        assertNull(question.pop());
    }

    @Test
    public void peek_WorksAsUsual()
    {
        question = new Question3_2<Integer>();
        assertNull(question.peek());

        question.push(2);
        question.push(4);
        question.push(8);
        assertPeekDataEquals(8);
        assertPeekDataEquals(8);

        question.pop();
        assertPeekDataEquals(4);

        question.push(16);
        assertPeekDataEquals(16);

        question.pop();
        question.pop();
        assertPeekDataEquals(2);

        question.pop();
        assertNull(question.peek());
    }

    @Test
    public void min_Works()
    {
        question = new Question3_2<Integer>();
        assertNull(question.min());

        question.push(4);
        assertMinDataEquals(4);

        question.push(8);
        assertMinDataEquals(4);
        assertPeekDataEquals(8);

        question.push(16);
        question.push(32);
        question.push(64);
        assertMinDataEquals(4);
        assertPeekDataEquals(64);
        assertPopDataEquals(64);
        assertMinDataEquals(4);
        assertPeekDataEquals(32);

        question.push(2);
        assertMinDataEquals(2);
        assertPeekDataEquals(2);

        question.push(128);
        assertPeekDataEquals(128);
        assertPopDataEquals(128);

        assertPopDataEquals(2);
        assertMinDataEquals(4);

        assertPopDataEquals(32);
        assertPopDataEquals(16);
        assertPopDataEquals(8);
        assertPopDataEquals(4);

        assertNull(question.min());
        assertNull(question.peek());
        assertNull(question.pop());
    }

    private void assertPopDataEquals(int expected)
    {
        assertStackDataEquals(expected, question.pop());
    }

    private void assertPeekDataEquals(int expected)
    {
        assertStackDataEquals(expected, question.peek());
    }

    private void assertMinDataEquals(int expected)
    {
        assertStackDataEquals(expected, question.min());
    }

    private void assertStackDataEquals(int expected, int actual)
    {
        assertEquals(expected, actual);
    }

}
