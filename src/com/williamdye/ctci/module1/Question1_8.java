package com.williamdye.ctci.module1;

import com.williamdye.ctci.Question;

/**
 * TASK:
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation
 * of s1 using only one call to isSubstring.
 *
 * EXAMPLE:
 * "waterbottle" is a rotation of "erbottlewat".
 */
public class Question1_8 implements Question
{

    private String firstString;
    private String secondString;
    private boolean isRotation;

    public Question1_8(String s1, String s2)
    {
        this.firstString = s1;
        this.secondString = s2;
    }

    @Override
    public void solve()
    {
        this.isRotation = stringsAreNotNull() && stringsAreNotEmpty() && lengthsMatch() && isRotation();
    }

    private boolean stringsAreNotNull()
    {
        return (firstString != null) && (secondString != null);
    }

    private boolean stringsAreNotEmpty()
    {
        return !firstString.isEmpty() && !secondString.isEmpty();
    }

    private boolean lengthsMatch()
    {
        return (firstString.length() == secondString.length());
    }

    private boolean isRotation()
    {
        String firstStringTwice = String.format("%s%s", firstString, firstString);
        return isSubstring(secondString, firstStringTwice);
    }

    /** This method would be provided. */
    private boolean isSubstring(String s1, String s2)
    {
        return s2.contains(s1);
    }

    public boolean getResult()
    {
        return this.isRotation;
    }

}
