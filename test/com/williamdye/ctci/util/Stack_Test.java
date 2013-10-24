package com.williamdye.ctci.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Stack_Test
{

    private Stack<Integer> stack;

    @Test
    public void getSize_ReturnsCorrectSize()
    {
        stack = new Stack<Integer>();
        assertStackSizeEquals(0);
        stack.push(11);
        assertStackSizeEquals(1);
        stack.push(22);
        assertStackSizeEquals(2);
        stack.push(44);
        assertStackSizeEquals(3);
        stack.peek();
        assertStackSizeEquals(3);
        stack.pop();
        assertStackSizeEquals(2);
        stack.pop();
        assertStackSizeEquals(1);
        stack.push(88);
        assertStackSizeEquals(2);
        stack.pop();
        assertStackSizeEquals(1);
        stack.pop();
        assertStackSizeEquals(0);
    }

    @Test
    public void pop_ReturnsCorrectData()
    {
        stack = new Stack<Integer>();
        int[] pushValues = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] popValues = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int pushValue : pushValues)
            stack.push(pushValue);
        for (int popValue : popValues)
            assertPopDataEquals(popValue);
        assertNull(stack.pop());
    }

    @Test
    public void peek_ReturnsCorrectData()
    {
        stack = new Stack<Integer>();
        stack.push(2);
        stack.push(4);
        stack.push(8);
        stack.push(16);
        assertPeekDataEquals(16);
        stack.pop();
        assertPeekDataEquals(8);
        assertPeekDataEquals(8);
        stack.pop();
        assertPeekDataEquals(4);
        stack.pop();
        assertPeekDataEquals(2);
        stack.pop();
        assertNull(stack.peek());
    }

    @Test
    public void monadConstructor_Works()
    {
        int VALUE = 1234;
        stack = new Stack<Integer>(VALUE);
        assertStackSizeEquals(1);
        assertPeekDataEquals(VALUE);
        assertPopDataEquals(VALUE);
        assertStackSizeEquals(0);
        assertNull(stack.peek());
        assertNull(stack.pop());
    }

    private void assertStackSizeEquals(int expected)
    {
        assertEquals(expected, stack.getSize());
    }

    private void assertPopDataEquals(int expected)
    {
        assertStackDataEquals(expected, stack.pop());
    }

    private void assertPeekDataEquals(int expected)
    {
        assertStackDataEquals(expected, stack.peek());
    }

    private void assertStackDataEquals(int expected, int actual)
    {
        assertEquals(expected, actual);
    }

}
