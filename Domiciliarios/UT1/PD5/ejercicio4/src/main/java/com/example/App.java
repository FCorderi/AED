package com.example;

public class App {

    static void stringsToNumbers(String[] param){
        // this program requires a vector 
        // with size 2 as param
        if (param.length == 2) {
            // convert strings to numbers
            float a = (Float.valueOf (param[0])).floatValue();
            float b = (Float.valueOf (param[1])).floatValue();
            // do some arithmetic
            System.out.println("a + b = " +
            (a + b));
            System.out.println("a - b = " +
            (a - b));
            System.out.println("a * b = " +
            (a * b));
            System.out.println("a / b = " +
            (a / b));
            System.out.println("a % b = " +
            (a % b));
        } else {
            System.out.println("This program " +
            "requires a vector with size 2 as param.");
        }
    }
    public static void main( String[] args )
    {
        String[] valores = {"13.4", "66.1"};

        stringsToNumbers(valores);
    
    }
}

// 1)
// Salida con los valores 13.4 y 66.1
// a + b = 79.5
// a - b = -52.699997
// a * b = 885.7399
// a / b = 0.20272315
// a % b = 13.4

// 2)
// La linea 10 se debería cambiar por:
// int a = (Integer.valueOf (param[0])).intValue();
// y la linea 11 por 
// int a = (Integer.valueOf (param[1])).intValue();