package com.williamdye.ctci.module1;

import com.williamdye.ctci.AbstractQuestion;

/**
 * TASK: Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.
 * Clearly, this is a Java implementation, but I have tried to make it as close to a C implementation as possible.
 * The C implementation (as yet untested) is given as a comment below.
 */
public class Question1_2 extends AbstractQuestion
{

    public Question1_2(String[] args)
    {
        super(args);
    }

    @Override
    public void solve()
    {
        for (String string : args) {
            reverse(string.toCharArray());
        }
    }

    private static void reverse(char[] str)
    {
        int length = str.length;
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
        println(new String(str));
    }

    private static void println(String message)
    {
        System.out.println(message);
    }

    public static void main(String[] args)
    {
        new Question1_2(args).solve();
    }

    /*
    #include <stdio.h>
    #include <string.h>

    void reverse(char* str)
    {
        int length = strlen(str);
        int i, j;
        for (i = 0, j = length - 1; i < j; i++, j--) {
            swap(str, i, j);
        }
        printf("%s\n", str);
    }

    void swap(char* str, const int i, const int j)
    {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
     */
}
