package com.williamdye.ctci.module1;

import org.junit.*;

import java.io.*;

import static com.williamdye.ctci.module1.Question1_3.MATCH_FORMAT;
import static org.junit.Assert.*;

public class Question1_3_Test
{

    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private String[] args;

    @BeforeClass
    public static void setUpOutputStream()
    {
        System.setOut(new PrintStream(outputStream));
    }

    @Before
    public void resetOutputStream()
    {
        outputStream.reset();
    }

    @Test
    public void solveWithPermutedStrings_PrintsMatches()
    {
        args = new String[] {
                "abcdefgh", "dhbfaceg",
                "10010010", "00000111",
                "erised", "desire",
                "x_y!z", "!zx_y",
                "Identical", "Identical"
        };
        new Question1_3(args).solve();
        assertConsoleLinesMatchExpectedFormat();
    }

    private void assertConsoleLinesMatchExpectedFormat()
    {
        String[] lines = outputStream.toString().split("\n");
        for (int i = 0, j = 0; i < args.length - 1; i+= 2, j++) {
            assertEquals(String.format(MATCH_FORMAT, args[i], args[i + 1]), lines[j]);
        }
    }

    @Test
    public void solveWithNonPermutedStrings_PrintsNothing()
    {
        args = new String[] {
                "12345", "67890",
                "most strings", "won't work",
                "1000", "1100",
                "Harry", "harry",
                "almost", "alm0st",
        };
        new Question1_3(args).solve();
        assertConsoleOutputIsEmpty();
    }

    private void assertConsoleOutputIsEmpty()
    {
        assertTrue(outputStream.toString().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void solveWithInvalidArgs_ThrowsException()
    {
        args = new String[] {"all by myself"};
        new Question1_3(args).solve();
    }

}
