package com.example.controller;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAsFirstClassCitizen {

    public static String concatStringStaticMethod(String str1, String str2) {
        return str1.concat(str2);
    }

    static BiFunction<String, String, String> concatFunction = (a, b) -> {
        return a+b;
    };

    public String concatStringInstanceMethod(String str1, String str2) {
        return str1.concat(str2);
    }

    public static String concatAndTransform(String str1, String str2, Function<String, String> transform) {
        String str = str1 + str2;
        if (transform != null) {
            str = transform.apply(str);
        }
        return str;
    }
//    public static void main(String[] args) {
//        BiFunction<String, String, String> concatStringStaticMethod = FunctionAsFirstClassCitizen::concatStringStaticMethod;
//        System.out.println(concatStringStaticMethod.apply("Hello ", "World! From Static function"));
//
//        System.out.println(concatFunction.apply("Hello ", "World! From Bi-function"));
//
//        FunctionAsFirstClassCitizen fafc = new FunctionAsFirstClassCitizen();
//        BiFunction<String, String, String> concatStringInstanceMethod = fafc::concatStringInstanceMethod;
//        System.out.println(concatStringInstanceMethod.apply("Hello ", "World! from Instance method"));
//        /**
//        HelloWorld! From Static function
//        HelloWorld! From Bi-function
//        HelloWorld! from Instance method
//         */
//
//        // How functions can be passed as parameter
//        // task: concat 2 string and do operation passed as argument to function as operation-function
//        Function<String, String> uppercase = (str) -> {
//            return str.toUpperCase();
//        };
//        Function<String, String> lowercase = (str) -> {
//            return str.toLowerCase();
//        };
//        System.out.println(concatAndTransform("Hello ", "world!", uppercase));
//        System.out.println(concatAndTransform("HELLO ", "WORLD!", lowercase));
//
//        //todo I dont know why we can not call FunctionAsFirstClassCitizen::concatAndTransform
//    }
}
