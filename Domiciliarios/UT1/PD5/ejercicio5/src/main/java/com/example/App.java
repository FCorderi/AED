package com.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        double d = 888.51;
        String s = Double.toString(d);
        int dot = s.indexOf('.');
        System.out.println(dot + " digits " +
                "before decimal point.");
        System.out.println((s.length() - dot - 1) +
                " digits after decimal point.");
    }
}

// La salida es:
// 3 digits before decimal point.
// 2 digits after decimal point.

// En el primer dato es porque al empezar a contar los indices del string en 0. el "." está en el indice 3.
// En el segundo dato es porque s.length vale 6, le restamos dot, que vale 3 como vimos en el primer dato, y luego le restamos 1 
// por lo cual nos da 2. 

