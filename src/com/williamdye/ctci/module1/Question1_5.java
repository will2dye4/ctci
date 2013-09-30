package com.williamdye.ctci.module1;

import com.williamdye.ctci.AbstractQuestion;

/**
 * TASK: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string "aabcccccaaa" would become
 * "a2b1c5a3". If the "compressed" string would not become smaller than the original
 * string, your method should return the original string.
 */
public class Question1_5 extends AbstractQuestion
{

    private StringBuffer buffer;
    private char previousCharacter;
    private int characterCount;

    public Question1_5(String[] args)
    {
        super(args);
        buffer = new StringBuffer();
    }

    @Override
    public void solve()
    {
        for (String string : args) {
            String compressedString = compress(string);
            println(compressedString);
        }
    }

    private String compress(String string)
    {
        resetState();
        for (char current : string.toCharArray()) {
            if (current == previousCharacter) {
                characterCount++;
            } else {
                appendCharacterAndCount();
                updatePreviousCharacter(current);
            }
        }
        appendFinalCharacter(string.charAt(string.length() - 1));
        return bufferOrString(string);
    }

    private void resetState()
    {
        updatePreviousCharacter('\0');
        buffer.setLength(0);
    }

    private void appendCharacterAndCount()
    {
        if (previousCharacter != '\0') {
            buffer.append(previousCharacter);
            buffer.append(characterCount);
        }
    }

    private void updatePreviousCharacter(char previous)
    {
        previousCharacter = previous;
        characterCount = 1;
    }

    private void appendFinalCharacter(char last)
    {
        if (characterCount > 1)
            previousCharacter = last;
        appendCharacterAndCount();
    }

    private String bufferOrString(String string)
    {
        return (buffer.length() < string.length() ? buffer.toString() : string);
    }

    public static void main(String[] args)
    {
        new Question1_5(args).solve();
    }

}