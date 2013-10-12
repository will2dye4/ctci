package com.williamdye.ctci.module2;

import com.williamdye.ctci.AbstractQuestion;
import com.williamdye.ctci.util.Digit;
import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;

/**
 * TASK:
 * You have two numbers represented by a linked list, where each node contains
 * a single digit. The digits are stored in reverse order, such that the 1's digit
 * is at the head of the list. Write a function that adds the two numbers and returns
 * the sum as a linked list.
 *
 * EXAMPLE:
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 *
 * FOLLOW UP:
 * Suppose the digits are stored in forward order. Repeat the above problem.
 */
public class Question2_5 extends AbstractQuestion
{

    private LinkedList<Digit> firstNumber;
    private LinkedList<Digit> secondNumber;
    private LinkedList<Digit> sum;

    public Question2_5(LinkedList<Digit> first, LinkedList<Digit> second)
    {
        this.firstNumber = first;
        this.secondNumber = second;
        this.sum = null;
    }

    @Override
    public void solve()
    {
        int firstValue = getValueFromList(firstNumber);
        int secondValue = getValueFromList(secondNumber);
        createSumFromResult(firstValue + secondValue);
    }

    private int getValueFromList(LinkedList<Digit> list)
    {
        int value = 0;
        int multiplier = 1;
        LinkedListNode<Digit> current = list.getHead();
        while (current != null) {
            value += (multiplier * current.getData().intValue());
            multiplier *= 10;
            current = current.getNext();
        }
        return value;
    }

    private void createSumFromResult(int result)
    {
        int digit;
        while (result > 0) {
            digit = result % 10;
            appendDigitToSum(new Digit(digit));
            result -= digit;
            result /= 10;
        }
    }

    private void appendDigitToSum(Digit digit)
    {
        if (sum == null)
            sum = new LinkedList<Digit>(digit);
        else
            sum.appendToTail(digit);
    }

    public LinkedList<Digit> getSum()
    {
        return this.sum;
    }

}
