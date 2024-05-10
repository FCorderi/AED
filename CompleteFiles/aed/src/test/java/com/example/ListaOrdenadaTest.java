package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.*;

import com.example.ListaOrdenada.ListaOrdenada;

/**
 * Unit test for simple App.
 */
public class ListaOrdenadaTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void insertarNumDesordenados()
    {
         ListaOrdenada<String> lista = new ListaOrdenada<String>();
        
        lista.insertar("3", "3");
        lista.insertar("1", "1");
        lista.insertar("2", "2");
        
        assertTrue(lista.imprimir().equals("[1, 2, 3]"));
    }

    @Test
    public void insertarNumInvertidos()
    {
         ListaOrdenada<String> lista = new ListaOrdenada<String>();
        
        lista.insertar("3", "3");
        lista.insertar("2", "2");
        lista.insertar("1", "1");
        
        assertTrue(lista.imprimir().equals("[1, 2, 3]"));
    }
}