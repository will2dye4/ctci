package com.williamdye.ctci.module3;

import com.williamdye.ctci.util.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * TASK:
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack
 * exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
 * SetOfStacks should be composed of several stacks and should create a new stack
 * once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop()
 * should behave identically to a single stack (that is, pop() should return the same
 * values as it would if there were just a single stack).
 *
 * FOLLOW UP:
 * Implement a function popAt(int index) which performs a pop operation
 * on a specific sub-stack.
 */
public class Question3_3<T>
{

    protected static final int DEFAULT_STACK_CAPACITY = 100;

    private List<Stack<T>> stackList;
    private Stack<T> currentStack;
    private int currentStackIndex;
    private int capacity;

    public Question3_3()
    {
        this(DEFAULT_STACK_CAPACITY);
    }

    public Question3_3(int capacity)
    {
        this.stackList = new ArrayList<Stack<T>>();
        this.stackList.add(new Stack<T>());
        this.currentStackIndex = 0;
        this.capacity = capacity;
        updateCurrentStack();
    }

    private void updateCurrentStack()
    {
        currentStack = stackList.get(currentStackIndex);
    }

    public void push(T data)
    {
        if (stackIndexShouldBeIncremented()) {
            currentStackIndex += 1;
            if (newStackShouldBeCreated())
                stackList.add(new Stack<T>());
            updateCurrentStack();
        }
        currentStack.push(data);
    }

    private boolean stackIndexShouldBeIncremented()
    {
        return (currentStack.getSize() == capacity);
    }

    private boolean newStackShouldBeCreated()
    {
        return (currentStackIndex == stackList.size());
    }

    public T pop()
    {
        T data = currentStack.pop();
        if (stackIndexShouldBeDecremented()) {
            currentStackIndex -= 1;
            updateCurrentStack();
        }
        return data;
    }

    private boolean stackIndexShouldBeDecremented()
    {
        return (currentStack.isEmpty() && (currentStackIndex > 0));
    }

    public T peek()
    {
        return currentStack.peek();
    }

}
