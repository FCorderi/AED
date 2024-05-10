package com.example;

import com.example.Lista.TDALista;
import com.example.Lista.TDANodo;
import com.example.ListaOrdenada.ListaOrdenada;

public class App 
{
    public static void main( String[] args )
    {
        ListaOrdenada<String> lista = new ListaOrdenada<String>();
        
        lista.insertar("3", "3");
        lista.insertar("1", "1");
        lista.insertar("2", "2");
        lista.imprimir();
    }
}
