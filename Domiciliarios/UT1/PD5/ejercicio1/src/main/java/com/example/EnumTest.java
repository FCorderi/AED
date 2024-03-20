package com.example;

public class EnumTest {
    public static enum Dias {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    Dias dia;
    
    public EnumTest(Dias dia) {
        this.dia = dia;
    }

    public void clasesDeLaSemana(){
        
    }

    public void tengoClases() {
        switch (dia) {
            case LUNES: case MIERCOLES:
                System.out.println("Es " + dia.toString().toLowerCase() + " tenes Algoritmo y estructura de datos.");
                break;
                    
            case MARTES: case JUEVES: case VIERNES:
                System.out.println("Es " + dia.toString().toLowerCase() + " tenes otras clases.");
                break;
                        
            default:
                System.out.println("Es " + dia.toString().toLowerCase() + ", es finde, no tenes clase....");
                break;
        }
    }
}
