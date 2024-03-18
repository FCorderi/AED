package com.example;
 

/**
 * Hello world!
 *
 */
public class Alumno {
    private String nombre;

    public Alumno(String Nombre) {
        this.nombre = Nombre;
    }

    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }

    public static void main(String[] args) {
        Alumno alumno = new Alumno("Felipe");
        System.out.println(alumno.getNombreAdmiracion());
        System.out.println(Metodos.recorrer("Pedrito clavó un clavito"));
        System.out.println(Metodos.getValor());
        System.out.println(Metodos.getPrimerCaracter("Perro"));
        System.out.println(Metodos.paraAString(0));
        
    }

}


//El error era que al crear alumno a nombre se le asignaba el valor null.
//Lo solucioné agregandole el parametro Nombre al contructor de alumo y asignandolo a la variable nombre.


//Todos los errores los detecté ejecutando el codigo, viendo el error que aparecía en consola y analizando el codigo.