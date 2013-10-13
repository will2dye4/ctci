package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Question2_7_Test
{

    private LinkedList<Character> list;

    @Test
    public void solveWithEvenLengthPalindrome_ReturnsTrue()
    {
        setUpListAndAssertResultIs(true, '1', '0', '0', '1');
    }

    @Test
    public void solveWithOddLengthPalindrome_ReturnsTrue()
    {
        setUpListAndAssertResultIs(true, 'r', 'a', 'c', 'e', 'c', 'a', 'r');
    }

    @Test
    public void solveWithLengthOneList_ReturnsTrue()
    {
        setUpListAndAssertResultIs(true, '!');
    }

    @Test
    public void solveWithNonPalindrome_ReturnsFalse()
    {
        setUpListAndAssertResultIs(false, 'p', 'a', 'l', 'i', 'n', 'd', 'r', 'o', 'm', 'e');
    }

    private void setUpListAndAssertResultIs(boolean expectTrue, Character... characters)
    {
        setUpLinkedList(characters);
        Question2_7<Character> question = new Question2_7<Character>(list);
        question.solve();
        if (expectTrue)
            assertTrue(question.isPalindrome());
        else
            assertFalse(question.isPalindrome());
    }

    private void setUpLinkedList(Character... characters)
    {
        list = new LinkedList<Character>(characters[0]);
        for (int i = 1; i < characters.length; i++)
            list.appendToTail(characters[i]);
    }

}
