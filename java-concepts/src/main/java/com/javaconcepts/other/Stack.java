package com.javaconcepts.other;

import java.lang.reflect.Array;

public class Stack<T> {

    private final T[] stack;
    private final int size;
    private int topOfStack = -1;

    public Stack(int size, Class<T> tClass) {
        this.size = size;
        this.stack = (T[]) Array.newInstance(tClass, size);
    }

    public void push(T element) {
        System.out.println();
        System.out.println(topOfStack);

        if ((topOfStack + 1) < size) {
            this.stack[++topOfStack] = element;
            displayStack();
        } else {
            System.out.println("Stacks full");
        }
    }

    public void pop() {

        if (topOfStack != -1) {
            stack[topOfStack--] = null;

            displayStack();
        } else {
            System.out.println("stack is empty");
        }
    }

    private void displayStack() {
        System.out.println();
        for(T element: stack) System.out.print(element + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<String> stackOfStrings = new Stack<>(4, String.class);
        stackOfStrings.push("a");
        stackOfStrings.push("a");
        stackOfStrings.push("a");
        stackOfStrings.push("a");
        stackOfStrings.push("a");

        stackOfStrings.pop();
        stackOfStrings.pop();
        stackOfStrings.pop();
        stackOfStrings.pop();
        stackOfStrings.pop();
    }
}
