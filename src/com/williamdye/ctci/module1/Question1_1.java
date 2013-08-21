package com.williamdye.ctci.module1;

import com.williamdye.ctci.AbstractQuestion;

import java.util.*;

/**
 * TASK: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class Question1_1 extends AbstractQuestion
{

    private boolean optimizeForSpace;

    public Question1_1(String[] args)
    {
        this(true, args);
    }

    public Question1_1(boolean spaceOptimization, String[] args)
    {
        super(args);
        this.optimizeForSpace = spaceOptimization;
    }

    @Override
    public void solve()
    {
        for (String string : args) {
            if (optimizeForSpace)
                assert hasAllUniqueCharacters1(string);
            else
                assert hasAllUniqueCharacters2(string);
        }
    }

    /**
     * Solution #1: Optimize for Space
     * Use nested for loops to check each character for duplication in the string.
     * This algorithm is O(n * n), where n is the length of the string, but it avoids
     * the use of additional data structures.
     */
    private static boolean hasAllUniqueCharacters1(String string)
    {
        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j))
                    return false;
            }
        }
        return true;
    }

    /**
     * Solution #2: Optimize for Time
     * This alternative uses a set to keep track of characters that have already occurred
     * in the string. Sets can efficiently check if they already contain a certain element.
     * This solution uses one additional data structure, but the benefit of the extra space
     * is a time complexity of just O(n).
     */
    private static boolean hasAllUniqueCharacters2(String string)
    {
        Set<Character> characters = new LinkedHashSet<Character>(string.length());
        for (char c : string.toCharArray()) {
            if (characters.contains(c))
                return false;
            characters.add(c);
        }
        return true;
    }

    public static void main(String[] args)
    {
        new Question1_1(args).solve();
    }

}
