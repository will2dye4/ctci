package com.williamdye.ctci;

public abstract class AbstractQuestion implements Question
{

    public abstract void solve();

    protected static void println(String message)
    {
        System.out.println(message);
    }

}
