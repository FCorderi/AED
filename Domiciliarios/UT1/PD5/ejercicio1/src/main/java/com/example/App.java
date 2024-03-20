package com.example;

import com.example.EnumTest.Dias;


public class App 
{
    public static void main( String[] args )
    {
        EnumTest primerDia = new EnumTest(Dias.LUNES);
        primerDia.tengoClases();
        EnumTest segundoDia = new EnumTest(Dias.MARTES);
        segundoDia.tengoClases();
        EnumTest tercerDia = new EnumTest(Dias.SABADO);
        tercerDia.tengoClases();

        System.out.println();

        EnumTest diaSemanal = new EnumTest(null);
        for (Dias a : Dias.values()){
            diaSemanal.dia = a;
            diaSemanal.tengoClases();
        }


    }
}
