package com.williamdye.ctci.module1;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class Question1_2_Test
{
    private static final String[] args = {"William", "ZYXWVUTS", "racecar", "7331", "<><><><><>", "1", "12"};
    private static final String[] argsReversed = {"mailliW", "STUVWXYZ", "racecar", "1337", "><><><><><", "1", "21"};

    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeClass
    public static void setUpOutputStream()
    {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void invokeMain_PrintsReversedStrings()
    {
        new Question1_2(args).solve();
        assertConsoleLinesEqualReversedArgs();
    }

    private void assertConsoleLinesEqualReversedArgs()
    {
        String[] consoleLines = outputStream.toString().split("\n");
        for (int i = 0; i < argsReversed.length; i++) {
            assertEquals(argsReversed[i], consoleLines[i]);
        }
    }

}
