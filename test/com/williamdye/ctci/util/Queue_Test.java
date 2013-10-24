package com.williamdye.ctci.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Queue_Test
{

    private Queue<Integer> queue;

    @Test
    public void getSize_ReturnsCorrectSize()
    {
        queue = new Queue<Integer>();
        assertQueueSizeEquals(0);
        queue.enqueue(12);
        assertQueueSizeEquals(1);
        queue.enqueue(24);
        assertQueueSizeEquals(2);
        queue.dequeue();
        assertQueueSizeEquals(1);
        queue.enqueue(48);
        assertQueueSizeEquals(2);
        queue.enqueue(96);
        assertQueueSizeEquals(3);
        queue.dequeue();
        assertQueueSizeEquals(2);
        queue.dequeue();
        assertQueueSizeEquals(1);
        queue.dequeue();
        assertQueueSizeEquals(0);
    }

    @Test
    public void dequeue_ReturnsCorrectData()
    {
        queue = new Queue<Integer>();
        int[] values = {9, 4, 6, 1, 8, 3, 2, 7, 5};
        for (int value : values)
            queue.enqueue(value);
        for (int value : values)
            assertDequeueDataEquals(value);
        assertNull(queue.dequeue());
    }

    @Test
    public void monadConstructor_Works()
    {
        int VALUE = 4321;
        queue = new Queue<Integer>(VALUE);
        assertQueueSizeEquals(1);
        assertDequeueDataEquals(VALUE);
        assertQueueSizeEquals(0);
        assertNull(queue.dequeue());
    }

    private void assertQueueSizeEquals(int expected)
    {
        assertEquals(expected, queue.getSize());
    }

    private void assertDequeueDataEquals(int expected)
    {
        assertEquals(expected, (int)queue.dequeue());
    }

}
