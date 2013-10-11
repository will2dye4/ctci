package com.williamdye.ctci.module1;

/**
 * TASK:
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string.
 *
 * EXAMPLES:
 * "aabcccccaaa" => "a2b1c5a3"
 * "abcdefgh" => "abcdefgh"
 */
public class Question1_5 extends AbstractStringQuestion
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
