package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;

import java.util.Stack;

/**
 * TASK:
 * Implement a function to check if a linked list is a palindrome.
 */
public class Question2_7<T> extends AbstractLinkedListQuestion<T>
{

    private int numberOfNodes;
    private boolean palindrome;
    private LinkedListNode<T> current;
    private Stack<T> stack;

    public Question2_7(LinkedList<T> list)
    {
        super(list);
        this.numberOfNodes = 0;
        this.palindrome = false;
        this.current = list.getHead();
        this.stack = new Stack<T>();
    }

    @Override
    public void solve()
    {
        getNodeCount();
        pushFirstHalfOntoStack();
        checkForPalindrome();
    }

    private void getNodeCount()
    {
        while (current != null) {
            numberOfNodes += 1;
            current = current.getNext();
        }
    }

    private void pushFirstHalfOntoStack()
    {
        int nodesToPush = numberOfNodes / 2;
        current = list.getHead();
        while (nodesToPush > 0) {
            stack.push(current.getData());
            nodesToPush -= 1;
            current = current.getNext();
        }
    }

    private void checkForPalindrome()
    {
        if ((numberOfNodes % 2) == 1)
            current = current.getNext();
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(current.getData()))
                return;
            current = current.getNext();
        }
        this.palindrome = true;
    }

    public boolean isPalindrome()
    {
        return this.palindrome;
    }

}