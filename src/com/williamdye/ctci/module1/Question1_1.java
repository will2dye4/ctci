package com.williamdye.ctci.module1;

import java.util.*;

public class Question1_1
{

    /**
     * TASK: Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     * @param args  an array of strings to test
     */
    public static void main(String[] args)
    {
        for (String string : args) {
            assert hasAllUniqueCharacters(string);
            assert _hasAllUniqueCharacters(string);
        }
    }

    /**
     * Use nested for loops to check each character for duplication in the string.
     * This algorithm is O(n * n), where n is the length of the string, but it avoids
     * the use of additional data structures.
     */
    private static boolean hasAllUniqueCharacters(String string)
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
     * Alternative: Use a set to keep track of characters that have already occurred
     * in the string. Sets can efficiently check if they already contain a certain element.
     * This solution uses one additional data structure, but the benefit of the extra space
     * is a time complexity of just O(n).
     */
    @SuppressWarnings("unused")
    private static boolean _hasAllUniqueCharacters(String string)
    {
        Set<Character> characters = new LinkedHashSet<Character>(string.length());
        for (char c : string.toCharArray()) {
            if (characters.contains(c))
                    return false;
            characters.add(c);
        }
        return true;
    }

}
