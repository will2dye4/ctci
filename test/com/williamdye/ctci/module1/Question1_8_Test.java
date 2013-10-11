package com.williamdye.ctci.module1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Question1_8_Test
{

    private String[] testStrings;
    private Question1_8 question;


    @Test
    public void solveWithRotatedStrings_ReturnsTrue()
    {
        testStrings = new String[] {
                "waterbottle", "erbottlewat",
                "waterbottle", "waterbottle",
                "10101101", "11011010",
                "William Dye ", "Dye William ",
                "1234567890", "6789012345"
        };

        for (int i = 0; i < testStrings.length; i += 2) {
            solveWithArgs(testStrings[i], testStrings[i + 1]);
            assertTrue(question.getResult());
        }
    }

    @Test
    public void solveWithNonRotatedStrings_ReturnsFalse()
    {
        testStrings = new String[] {
                "waterbottle", "water bottle",
                "11001010", "11011011",
                "William Dye", "Dye William",
                "1234567890", "23456789",
                "A man a plan", "A plan a man"
        };

        for (int i = 0; i < testStrings.length; i += 2) {
            solveWithArgs(testStrings[i], testStrings[i + 1]);
            assertFalse(question.getResult());
        }
    }

    @Test
    public void solveWithNullAndEmptyStrings_ReturnsFalse()
    {
        solveWithArgs(null, null);
        assertFalse(question.getResult());

        solveWithArgs("", "");
        assertFalse(question.getResult());
    }

    private void solveWithArgs(String s1, String s2)
    {
        question = new Question1_8(s1, s2);
        question.solve();
    }

}
