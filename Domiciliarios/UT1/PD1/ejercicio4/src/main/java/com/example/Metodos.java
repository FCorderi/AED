package com.example;

public class Metodos {
    // Los errores de "recorrer" eran qeu el loop for iniciaba en 1 en vez de 0
    // y el limite iba hasta i <= cadena.length lo cual producia el error "String
    // index out of range"
    public static int recorrer(String cadena) {
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    // El error era que se intentaba ingresar al indice 8 del vector lo cual
    // generaba el error "Index 8 out of bounds for length 8"
    // porque como los indices de los vectores arrancan en 0 al tener 8 elementos el
    // indice mas alto es 7
    public static int getValor() {
        int vector[] = { 6, 16, 26, 36, 46, 56, 66, 76 };
        int idx = 7;
        return vector[idx];
    }

    // El primer error era que se creaba un vector de Strings de tamaño 5 vacío,
    // luego fallaba al ejecutar string[1].charAt(1) porque se intentaba ejecutar
    // sobre null
    // Por último para conseguír el primer caractér el indice usado en charAt
    // debaría ser 0
    public static char getPrimerCaracter(String palabra) {
        String string[] = new String[5];
        return (palabra.charAt(0));
    }

    //El error estaba en la manera de pasar un valor de tipo int a String 
    //Dos maneras posibles de solucionarlo son las usadas en las variables aString y aString2
    public static String paraAString(int a) {

        String aString = String.valueOf(a);
        String aString2 = Integer.toString(a);
        return aString;
    }
}
