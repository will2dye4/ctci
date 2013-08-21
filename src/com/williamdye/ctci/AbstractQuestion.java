package com.williamdye.ctci;

public abstract class AbstractQuestion implements Question
{

    protected String[] args;

    public AbstractQuestion(String[] args)
    {
        this.args = args;
    }

    public abstract void solve();

}
