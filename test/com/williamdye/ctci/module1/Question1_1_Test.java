package com.williamdye.ctci.module1;

import org.junit.Test;

import static org.junit.Assert.fail;

public class Question1_1_Test
{

    private String[] args;

    @Test
    public void solveWithUniqueStrings_Succeeds()
    {
        args = new String[] {"aquickbrownfxjmpsvethlzydg", "Mitch", "Mr. mitch", "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPp"};
        optimizeForSpace_Succeeds();
        optimizeForTime_Succeeds();
    }

    private void optimizeForSpace_Succeeds()
    {
        setSpaceOptimizationAndSolve(true);
    }

    private void optimizeForTime_Succeeds()
    {
        setSpaceOptimizationAndSolve(false);
    }

    private void setSpaceOptimizationAndSolve(boolean spaceOptimization)
    {
        try {
            new Question1_1(spaceOptimization, args).solve();
        } catch (AssertionError error) {
            fail(String.format("%s optimization", (spaceOptimization ? "space" : "time")));
        }
    }

    @Test(expected = AssertionError.class)
    public void solveWithNonUniqueStrings_ThrowsError()
    {
        args = new String[] {"William", "Little Bobby Tables", "zzzzzzzzz", "1011001110010100"};
        new Question1_1(args).solve();
    }

}
