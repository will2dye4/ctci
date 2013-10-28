package com.williamdye.ctci.module3;

/**
 * TASK:
 * Describe how you could use a single array to implement three stacks.
 *
 * NOTE:
 * I would like to have made this class accept a type parameter, so that it could be used
 * for types other than int, but Java does not allow the creation of generically-typed arrays.
 */
public class Question3_1
{

    private int[] array;
    private int[] tops;

    public Question3_1()
    {
        this(99);
    }

    public Question3_1(int arrayCapacity)
    {
        if ((arrayCapacity % 3) > 0)
            throw new IllegalArgumentException("array capacity must be a multiple of 3");

        this.array = new int[arrayCapacity];

        this.tops = new int[3];
        for (int i = 0; i < tops.length; i++)
            this.tops[i] = (i * (array.length / 3)) - 1;
    }

    public void push(int stackNumber, int data)
    {
        stackNumber -= 1;
        if (stackIsFull(stackNumber))
            throw new IllegalStateException(String.format("cannot push to stack #%d; stack is full", stackNumber + 1));
        tops[stackNumber] += 1;
        array[tops[stackNumber]] = data;
    }

    private boolean stackIsFull(int stackNumber)
    {
        return (tops[stackNumber] == (((stackNumber + 1) * (array.length / 3)) - 1));
    }

    public int pop(int stackNumber)
    {
        stackNumber -= 1;
        if (stackIsEmpty(stackNumber))
            throw new IllegalStateException(String.format("cannot pop from stack #%d; stack is empty", stackNumber + 1));
        int data = array[tops[stackNumber]];
        tops[stackNumber] -= 1;
        return data;
    }

    private boolean stackIsEmpty(int stackNumber)
    {
        return (tops[stackNumber] < (stackNumber * (array.length / 3)));
    }

    public int peek(int stackNumber)
    {
        stackNumber -= 1;
        if (stackIsEmpty(stackNumber))
            throw new IllegalStateException(String.format("cannot peek at stack #%d; stack is empty", stackNumber + 1));
        return array[tops[stackNumber]];
    }

}
