package com.williamdye.ctci.module1;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class Question1_4_Test
{
    private static final String[] args = new String[] {"William", "William Dye", "William Sims Dye", "   "};
    private static final String[] paddedArgs = new String[] {"William", "William%20Dye", "William%20Sims%20Dye", "%20%20%20"};


    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeClass
    public static void setUpOutputStream()
    {
        System.setOut(new PrintStream(outputStream));
    }


    @Test
    public void solve_Succeeds()
    {
        new Question1_4(args).solve();
        assertConsoleLinesEqualPaddedArgs();
    }

    private void assertConsoleLinesEqualPaddedArgs()
    {
        String[] lines = outputStream.toString().split("\n");
        for (int i = 0; i < paddedArgs.length; i++) {
            assertEquals(paddedArgs[i], lines[i]);
        }
    }

}
