package com.williamdye.ctci.module1;

import com.williamdye.ctci.AbstractQuestion;

/**
 * TASK: Write a method to replace all spaces in a string with '%20'. You may assume that
 * the string has sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if implementing
 * in Java, please use a character array so that you can perform this operation in place.)
 *
 * EXAMPLE:
 * Input:   "Mr John Smith    "
 * Output:  "Mr%20John%20Smith"
 */
public class Question1_4 extends AbstractQuestion
{

    private static final char SPACE = ' ';

    private char[] currentString;
    private int fromIndex;
    private int toIndex;

    public Question1_4(String[] args)
    {
        super(args);
        this.currentString = null;
        this.fromIndex = this.toIndex = 0;
    }

    @Override
    public void solve()
    {
        for (String string : args) {
            convertStringToPaddedCharArray(string);
            shiftStringAndEncodeSpaces();
            println(new String(currentString));
        }
    }

    private void convertStringToPaddedCharArray(String string)
    {
        char[] stringArray = string.toCharArray();
        int numberOfSpaces = 0;
        for (char c : stringArray) {
            if (c == SPACE)
                numberOfSpaces++;
        }
        char[] paddedString = new char[stringArray.length + (numberOfSpaces * 2)];
        System.arraycopy(stringArray, 0, paddedString, 0, stringArray.length);
        currentString = paddedString;
        fromIndex = stringArray.length - 1;
        toIndex = paddedString.length - 1;
    }

    private void shiftStringAndEncodeSpaces()
    {
        while (charactersLeftToCopy()) {
            if (currentCharacterIsSpace())
                urlEncodeSpace();
            else
                copyCurrentCharacter();
            fromIndex -= 1;
        }
    }

    private boolean charactersLeftToCopy()
    {
        return (fromIndex >= 0) && (toIndex > fromIndex);
    }

    private boolean currentCharacterIsSpace()
    {
        return (currentString[fromIndex] == SPACE);
    }

    private void urlEncodeSpace()
    {
        currentString[toIndex - 2] = '%';
        currentString[toIndex - 1] = '2';
        currentString[toIndex] = '0';
        toIndex -= 3;
    }

    private void copyCurrentCharacter()
    {
        currentString[toIndex] = currentString[fromIndex];
        toIndex -= 1;
    }

    public static void main(String[] args)
    {
        new Question1_4(args).solve();
    }

}
