package com.javaconcepts.other;

import java.util.Objects;

public class CanASingletonBeExtended {

    private static CanASingletonBeExtended canASingletonBeExtended;

    CanASingletonBeExtended() {

    }

    public static CanASingletonBeExtended getInstance() {

        if (Objects.isNull(canASingletonBeExtended)) {
            canASingletonBeExtended = new CanASingletonBeExtended();
        }

        return canASingletonBeExtended;
    }

    public void print() {
        System.out.println("Print");
    }
}

class ExtendASingletonClass extends CanASingletonBeExtended {
    private ExtendASingletonClass() {
        super();
    }
}
