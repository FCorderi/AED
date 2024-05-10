package com.example.ListaOrdenada;

import com.example.Lista.*;

public class ListaOrdenada<T> extends TDALista<T> {

    public ListaOrdenada() {
        super();
    }

    public void insertar(T dato, Comparable etiqueta){
        TDANodo nuevNodo = new TDANodo<T>(etiqueta, dato);
        insertar(nuevNodo);
    }

    /*
     * Inserta un nodo en la lista de manera ordenada.
     */
    @Override
    public void insertar(TDANodo<T> nuevo) {
        TDANodo<T> aux = getPrimero();
        if (aux == null || aux.getEtiqueta().compareTo(nuevo.getEtiqueta()) > 0) {
            setPrimero(nuevo);
            nuevo.setSiguiente(aux);
            setCantElementos((short) (cantElementos() + 1));
            return;
        }
        if (aux.getEtiqueta().compareTo(nuevo.getEtiqueta()) == 0) {
            return;
        }
        while (aux.getSiguiente() != null && aux.getSiguiente().getEtiqueta().compareTo(nuevo.getEtiqueta()) < 0) {
            aux = aux.getSiguiente();
        }
        nuevo.setSiguiente(aux.getSiguiente());
        setCantElementos((short) (cantElementos() + 1));
        aux.setSiguiente(nuevo);
    }
}