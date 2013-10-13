package com.williamdye.ctci.module2;

import com.williamdye.ctci.util.LinkedList;
import com.williamdye.ctci.util.LinkedListNode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TASK:
 * Given a circular linked list, implement an algorithm which returns the node
 * at the beginning of the loop.
 *
 * DEFINITION:
 * Circular linked list: A (corrupt) linked list in which a node's next pointer
 * points to an earlier node, so as to make a loop in the linked list.
 *
 * EXAMPLE:
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 */
public class Question2_6<T> extends AbstractLinkedListQuestion<T>
{

    private Set<LinkedListNode<T>> nodes;
    private LinkedListNode<T> loopNode;

    public Question2_6(LinkedList<T> list)
    {
        super(list);
        this.nodes = new LinkedHashSet<LinkedListNode<T>>();
        this.loopNode = null;
    }

    @Override
    public void solve()
    {
        LinkedListNode<T> current = list.getHead();
        while (current != null) {
            if (foundLoopNode(current))
                break;
            current = current.getNext();
        }
    }

    private boolean foundLoopNode(LinkedListNode<T> node)
    {
        if (nodes.contains(node)) {
            loopNode = node;
            return true;
        }
        nodes.add(node);
        return false;
    }

    public LinkedListNode<T> getLoopNode()
    {
        return this.loopNode;
    }

}
