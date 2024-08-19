package com.javaconcepts.access.modifiers.defaultlevelaccess;

import com.javaconcepts.access.modifiers.ParentWithProtectedMember;

public class Child extends ParentWithProtectedMember {

    public void tryingToAccessParentsMemberVariables() {
        // default and private not accessible
        System.out.println(protectedMember);
    }

    public static void main(String[] args) {
        // Cannot access Parent since its class level is default
    }
}
