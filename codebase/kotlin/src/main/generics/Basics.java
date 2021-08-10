package main.generics;

import java.util.ArrayList;
import java.util.List;

// Java
interface Source<T> {
    T nextT();
}

public class Basics {
    // Java
    // List<String> strs = new ArrayList<String>();
    // List<Object> objs = strs; // !!! A compile-time error here saves us from a runtime exception later.
    // objs.add(1); // Put an Integer into a list of Strings
    // String s = strs.get(0); // !!! ClassCastException: Cannot cast Integer to String

    // Java
    void demo(Source<String> strs) {
        // Source<Object> objects = strs; // !!! Not allowed in Java
        // ...
    }
}
