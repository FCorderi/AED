package com.example;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        String original = "este es el curso de Programación 2";
        StringBuilder result = new StringBuilder("hola");
        int index = original.indexOf('a');
        /* 1 */ result.setCharAt(0, original.charAt(0));
        /* 2 */ result.setCharAt(1, original.charAt(original.length() - 1));
        /* 3 */ result.insert(1, original.charAt(4));
        /* 4 */ result.append(original.substring(1, 4));
        /* 5 */ result.insert(3, (original.substring(index, index + 2) + " "));
        System.out.println(result);
    }
}
