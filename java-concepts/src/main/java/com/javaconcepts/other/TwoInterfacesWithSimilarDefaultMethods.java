package com.javaconcepts.other;

public class TwoInterfacesWithSimilarDefaultMethods {

    public static void main(String[] args) {
        ClassX classX = new ClassX();
        classX.print();
    }
}

interface InterfaceA {
    default void print() {
        System.out.println("Print A");
    }
}

interface InterfaceB {
    default void print() {
        System.out.println("Print B");
    }
}

class ClassX implements InterfaceA, InterfaceB {
    @Override
    public void print() {
        InterfaceA.super.print();
    }
}