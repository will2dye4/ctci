package com.williamdye.ctci.module1;

import com.williamdye.ctci.AbstractQuestion;

public abstract class AbstractStringQuestion extends AbstractQuestion
{

    protected String[] args;

    public AbstractStringQuestion(String[] args)
    {
        this.args = args;
    }

}
