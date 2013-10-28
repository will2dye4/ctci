package com.williamdye.ctci.module3;

import com.williamdye.ctci.util.Stack;

/**
 * TASK:
 * How would you design a stack which, in addition to push and pop, also has a function
 * min which returns the minimum element? Push, pop, and min should all operate in O(1) time.
 */
public class Question3_2<T extends Comparable<T>> extends Stack<T>
{

    private Stack<T> minStack;

    public Question3_2()
    {
        super();
        this.minStack = new Stack<T>();
    }

    @Override
    public void push(T data)
    {
        super.push(data);
        if (dataIsLessThanCurrentMin(data))
            minStack.push(data);
    }

    private boolean dataIsLessThanCurrentMin(T data)
    {
        return (minStack.getSize() == 0) || (data.compareTo(minStack.peek()) < 0);
    }

    @Override
    public T pop()
    {
        T data = super.pop();
        if (dataEqualsMinElement(data))
            minStack.pop();
        return data;
    }

    private boolean dataEqualsMinElement(T data)
    {
        return (data != null) && (data.equals(minStack.peek()));
    }

    public T min()
    {
        return minStack.peek();
    }

}
