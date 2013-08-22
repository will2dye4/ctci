package com.williamdye.ctci.module1;

import com.williamdye.ctci.AbstractQuestion;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TASK: Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Question1_3 extends AbstractQuestion
{

    protected static final String MATCH_FORMAT = "\"%s\"\t=>\t\"%s\"";

    private String firstString, secondString;
    private Map<Character, Integer> firstStringMap, secondStringMap;

    public Question1_3(String[] args)
    {
        super(args);
        if ((args.length % 2) != 0)
            throw new IllegalArgumentException("args.length must be a multiple of two!");
    }

    @Override
    public void solve()
    {
        for (int i = 0; i < args.length - 1; i += 2) {
            checkForPermutation(args[i], args[i + 1]);
        }
    }

    private void checkForPermutation(String first, String second)
    {
        firstString = first;
        secondString = second;
        countCharacters();
        compareCharacterCounts();
    }

    private void countCharacters()
    {
        firstStringMap = getCharacterCounts(firstString);
        secondStringMap = getCharacterCounts(secondString);
    }

    private Map<Character, Integer> getCharacterCounts(String string)
    {
        Map<Character, Integer> stringMap = new LinkedHashMap<Character, Integer>();
        for (char c : string.toCharArray()) {
            incrementCount(stringMap, c);
        }
        return stringMap;
    }

    private void incrementCount(Map<Character, Integer> map, char c)
    {
        if (map.containsKey(c))
            map.put(c, map.get(c) + 1);
        else
            map.put(c, 1);
    }

    private void compareCharacterCounts()
    {
        if (firstStringMap.keySet().size() != secondStringMap.keySet().size())
            return;

        for (char c : firstStringMap.keySet()) {
            if (countsDoNotMatch(c))
                return;
        }
        printMatch();
    }

    private boolean countsDoNotMatch(char c)
    {
        return !(firstStringMap.get(c).equals(secondStringMap.get(c)));
    }

    private void printMatch()
    {
        println(String.format(MATCH_FORMAT, firstString, secondString));
    }

    public static void main(String[] args)
    {
        new Question1_3(args).solve();
    }

}
