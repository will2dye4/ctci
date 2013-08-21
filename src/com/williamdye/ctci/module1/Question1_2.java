package com.williamdye.ctci.module1;

public class Question1_2
{

    /**
     * TASK: Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.
     * Clearly, this is a Java implementation, but I have tried to make it as close to a C implementation as possible.
     * The C implementation (as yet untested) is given as a comment below.
     * @param args  an array of strings to reverse
     *              The reversed strings will be printed to the console.
     */
    public static void main(String[] args)
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
