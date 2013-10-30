package com.williamdye.ctci.module3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Question3_5_Test
{

    private Question3_5<Integer> question;

    @Test
    public void enqueueAndDequeue_WorkAsUsual()
    {
        question = new Question3_5<Integer>();
        question.enqueue(1);
        question.enqueue(2);
        question.enqueue(3);
        assertDequeueDataEquals(1);
        assertDequeueDataEquals(2);

        question.enqueue(4);
        assertDequeueDataEquals(3);

        question.enqueue(5);
        question.enqueue(6);
        question.enqueue(7);
        question.enqueue(8);
        assertDequeueDataEquals(4);
        assertDequeueDataEquals(5);
        assertDequeueDataEquals(6);
        assertDequeueDataEquals(7);
        assertDequeueDataEquals(8);

        assertNull(question.dequeue());
    }

    private void assertDequeueDataEquals(int expected)
    {
        assertEquals(expected, (int)question.dequeue());
    }

}
