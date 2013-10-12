package com.williamdye.ctci.util;

public class Digit extends Number
{

    private Integer value;

    public Digit(int value)
    {
        this.value = value;
        if (valueIsInvalid())
            throw new IllegalArgumentException("value must be between 0 and 9, inclusive");
    }

    private boolean valueIsInvalid()
    {
        return (this.value < 0) || (this.value > 9);
    }

    @Override
    public int intValue()
    {
        return value;
    }

    @Override
    public long longValue()
    {
        return value.longValue();
    }

    @Override
    public float floatValue()
    {
        return value.floatValue();
    }

    @Override
    public double doubleValue()
    {
        return value.doubleValue();
    }

}
