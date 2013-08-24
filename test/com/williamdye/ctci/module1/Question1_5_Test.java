package com.williamdye.ctci.module1;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class Question1_5_Test
{

    private static final String[] compressedLongStrings = {"12031102140212", " 4>4 1g1c2", "a3b2c5d1", "h1e2y5"};
    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

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
    public void compressWithLongStrings_PrintsCompressedStrings()
    {
        final String[] args = {"1100010011110011", "    >>>> gcc", "aaabbcccccd", "heeyyyyy"};
        new Question1_5(args).solve();
        assertConsoleLinesEqualCompressedLongStrings();
    }

    private void assertConsoleLinesEqualCompressedLongStrings()
    {
        String[] consoleLines = outputStream.toString().split("\n");
        for (int i = 0; i < compressedLongStrings.length; i++) {
            assertEquals(compressedLongStrings[i], consoleLines[i]);
        }
    }

}
