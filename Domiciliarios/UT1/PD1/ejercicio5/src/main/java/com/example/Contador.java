package com.example;

/**
 * Hello world!
 *
 */
public class Contador 
{
    static final int MAX_CONT = 50;
    static int incremento = 1;
    static int contador = 1;

    static void mostrarContadorWhile(){
        while(contador <= MAX_CONT){
            System.out.println(contador);
            contador += incremento;
        }
        contador = 1;
    }

    static void mostrarContadorDoWhile(){
        do {
            System.out.println(contador);
            contador += incremento;
        }
        while(contador <= MAX_CONT);

        contador = 1;
    }

    static void mostrarContadorfor(){
        for( ; contador <= MAX_CONT ; contador += incremento){
            System.out.println(contador);
        }

        contador = 1;
    }

    public static void main( String[] args )
    {
        //System.out.println("Contador con while:");
        //mostrarContadorWhile();
        //System.out.println("\n");

        //System.out.println("Contador con do while:");
        //mostrarContadorDoWhile();
        //System.out.println("\n");

        System.out.println("Contador con for");
        mostrarContadorfor();
    }
}
