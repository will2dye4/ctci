package com.williamdye.ctci.module3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Question3_1_Test
{

    private Question3_1 question;

    @Test
    public void pushOnOneStackToCapacity_Works()
    {
        question = new Question3_1(9);
        question.push(1, 23);
        question.push(1, 42);
        question.push(1, 99);
    }

    @Test(expected=IllegalStateException.class)
    public void pushOnOneStackBeyondCapacity_ThrowsException()
    {
        question = new Question3_1(3);
        question.push(2, 4321);
        question.push(2, 1234);
    }

    @Test
    public void pushOnAllThreeStacksToCapacity_Works()
    {
        question = new Question3_1(9);
        question.push(1, 14);
        question.push(3, 98);
        question.push(2, 53);
        question.push(2, 76);
        question.push(1, 20);
        question.push(1, 100);
        question.push(3, 91);
        question.push(2, 200);
        question.push(3, 300);
    }

    @Test(expected=IllegalStateException.class)
    public void popOnEmptyStack_ThrowsException()
    {
        question = new Question3_1();
        question.pop(1);
    }

    @Test
    public void popOnOneNonEmptyStack_Works()
    {
        question = new Question3_1();
        question.push(3, 1);
        question.push(3, 2);
        question.push(3, 3);
        question.push(3, 4);
        question.push(3, 5);
        assertPopFromStackEquals(5, 3);
        assertPopFromStackEquals(4, 3);
        assertPopFromStackEquals(3, 3);
        assertPopFromStackEquals(2, 3);
        assertPopFromStackEquals(1, 3);
    }

    @Test
    public void popOnAllStacks_Works()
    {
        question = new Question3_1();
        question.push(1, 1);
        question.push(2, 2);
        question.push(1, 2);
        question.push(3, 3);
        question.push(2, 4);
        question.push(3, 6);
        question.push(2, 6);
        question.push(1, 3);
        question.push(3, 9);
        assertPopFromStackEquals(3, 1);
        assertPopFromStackEquals(9, 3);
        assertPopFromStackEquals(2, 1);
        assertPopFromStackEquals(6, 2);
        assertPopFromStackEquals(6, 3);
        assertPopFromStackEquals(1, 1);
        assertPopFromStackEquals(4, 2);
        assertPopFromStackEquals(2, 2);
        assertPopFromStackEquals(3, 3);
    }

    @Test(expected=IllegalStateException.class)
    public void peekOnEmptyStack_ThrowsException()
    {
        question = new Question3_1();
        question.peek(1);
    }

    @Test
    public void peekOnOneStack_Works()
    {
        question = new Question3_1();
        question.push(1, 25);
        question.push(1, 50);
        question.push(1, 100);
        assertPeekFromStackEquals(100, 1);
        assertPeekFromStackEquals(100, 1);
        question.pop(1);
        assertPeekFromStackEquals(50, 1);
        question.pop(1);
        assertPeekFromStackEquals(25, 1);
        assertPeekFromStackEquals(25, 1);
    }

    private void assertPopFromStackEquals(int expected, int stackNumber)
    {
        assertStackDataEquals(expected, question.pop(stackNumber));
    }

    private void assertPeekFromStackEquals(int expected, int stackNumber)
    {
        assertStackDataEquals(expected, question.peek(stackNumber));
    }

    private void assertStackDataEquals(int expected, int actual)
    {
        assertEquals(expected, actual);
    }

}
