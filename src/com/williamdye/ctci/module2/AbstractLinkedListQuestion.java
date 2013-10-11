package com.williamdye.ctci.module2;

import com.williamdye.ctci.AbstractQuestion;
import com.williamdye.ctci.util.LinkedList;

public abstract class AbstractLinkedListQuestion<T> extends AbstractQuestion
{

    protected LinkedList<T> list;

    public AbstractLinkedListQuestion(LinkedList<T> list)
    {
        this.list = list;
    }

}
