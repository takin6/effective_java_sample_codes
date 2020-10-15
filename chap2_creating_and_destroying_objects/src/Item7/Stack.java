package Item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        // results in memory leak
        // the stack maintains obsolete references to these objects.
        // An obsolete reference is simply a reference that will never be dereferenced again.
        // return elements[--size];

        Object result = elements[--size];
        elements[size] = null; // eliminate obsolete reference
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2*size+1);
        }
    }
}
