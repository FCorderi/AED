package com.example;

public class App {
    public static void main(String[] args) {
        // Ejercicio 2
        TArbolBB arbolBB = new TArbolBB<>();

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("clavesPrueba.txt");
        for (String linea : lineas) {
            arbolBB.insertar(new TElementoAB<String>(Integer.parseInt(linea), linea));
        }
        String[] recorridos = { "Preorden:", arbolBB.preOrden(), "Inorden:",
                arbolBB.inOrden(), "Postorden:", arbolBB.postOrden() };
        ManejadorArchivosGenerico.escribirArchivo("resultadoRecorridos.txt",
                recorridos);

        // Ejercicio 3
        TArbolBB arbolBB2 = new TArbolBB<>();

        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("claves1.txt");
        for (String linea : lineas2) {
            arbolBB2.insertar(new TElementoAB<String>(Integer.parseInt(linea), linea));
        }
       int[] valores = {10635, 4567, 12, 8978};
       for (int valor : valores){
        if (arbolBB2.buscar(valor) == null){
            System.out.println("EL valor " + valor + " no se encuentra en el arbol.");
        } else {
            System.out.println("EL valor " + valor + " si se encuentra en el arbol.");
        }
       }

       System.out.println(arbolBB2.preOrden());

       // La decima clave en el listado en preorden es el numero 797
    }
}
