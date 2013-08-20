package com.williamdye.ctci.module1;

import org.junit.Test;

import static org.junit.Assert.fail;

public class Question1_1_Test
{

    @Test
    public void invokeMainWithUniqueStrings_Succeeds()
    {
        final String[] args = {"aquickbrownfxjmpsvethlzydg", "Mitch", "Mr. mitch", "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPp"};
        try {
            Question1_1.main(args);
        } catch (AssertionError error) {
            fail();
        }
    }

    @Test(expected = AssertionError.class)
    public void invokeMainWithNonUniqueStrings_ThrowsError()
    {
        final String[] args = {"William", "Little Bobby Tables", "zzzzzzzzz", "1011001110010100"};
        Question1_1.main(args);
    }

}
