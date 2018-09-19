package com.example.controller;

import java.util.function.Function;
import java.util.function.Supplier;

public class HighOrderFunction {

    /**
        This function takes function as argument and return high order composite function to the caller
     */
    public static Supplier<String> transformAndConcat(final String str1,final String str2, Function<String, String> transform) {

        return () -> {
            String str=null;
            if (transform != null) {
                //Variable used in lambda should be final or effective final, hence declaring str1 and str2 as final
                // and storing transformed value in another variable
                str = transform.apply(str1) + transform.apply(str2);
            }
            return str;
        };
    }

//    public static void main(String[] args) {
//        Supplier<String> transformAndConcat = transformAndConcat("Hello-", "World!", (str) -> str.toUpperCase());
//        //transformAndConcat function will not be called until following line is executed i.e. Supplier.get()
//        System.out.println(transformAndConcat.get());
//    }
}
