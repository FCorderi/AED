package com.example.ArbolTrie;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe
 */
public interface INodoTrie {

    int buscarComparaciones(String s); // devuelve la cantidad de comparaciones!
    String buscar(String s);
    void imprimir();

    void insertar(String unaPalabra);
    void insertar(String unaPalabra, LinkedList<Integer> paginas);
    public void predecir(String prefijo, LinkedList<String> palabras);
    
    
}
