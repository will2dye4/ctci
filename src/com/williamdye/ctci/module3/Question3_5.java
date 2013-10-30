package com.williamdye.ctci.module3;

import com.williamdye.ctci.util.Stack;

/**
 * TASK:
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Question3_5<T>
{

    private Stack<T> queueStack, auxiliaryStack;

    public Question3_5()
    {
        this.queueStack = new Stack<T>();
        this.auxiliaryStack = new Stack<T>();
    }

    public void enqueue(T data)
    {
        emptyQueueStack();
        queueStack.push(data);
        repopulateQueueStack();
    }

    private void emptyQueueStack()
    {
        transferBetweenStacks(queueStack, auxiliaryStack);
    }

    private void repopulateQueueStack()
    {
        transferBetweenStacks(auxiliaryStack, queueStack);
    }

    private void transferBetweenStacks(Stack<T> fromStack, Stack<T> toStack)
    {
        while (!fromStack.isEmpty())
            toStack.push(fromStack.pop());
    }

    public T dequeue()
    {
        return queueStack.pop();
    }

}
