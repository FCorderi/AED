package com.example.Conjunto;

import com.example.ListaOrdenada.*;
import com.example.Lista.*;

public class Conjunto<T> extends ListaOrdenada<T> {
    public Conjunto() {
        super();
    }

    public Conjunto<T> union(Conjunto<T> conjuntoB) {
        Conjunto<T> nuevoConjunto = new Conjunto<>();
        TDANodo<T> nodoA = this.getPrimero();
        TDANodo<T> nodoB = conjuntoB.getPrimero();

        while (nodoA != null && nodoB != null) {
            if (nodoA.getEtiqueta().compareTo(nodoB.getEtiqueta()) < 0) {
                nuevoConjunto.insertar(nodoA.getDato(), nodoA.getEtiqueta());
                nodoA = nodoA.getSiguiente();
            } else if (nodoA.getEtiqueta().compareTo(nodoB.getEtiqueta()) > 0) {
                nuevoConjunto.insertar(nodoB.getDato(), nodoB.getEtiqueta());
                nodoB = nodoB.getSiguiente();
            } else {
                nuevoConjunto.insertar(nodoA.getDato(), nodoA.getEtiqueta());
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            }
        }

        while (nodoA != null) {
            nuevoConjunto.insertar(nodoA.getDato(), nodoA.getEtiqueta());
            nodoA = nodoA.getSiguiente();
        }

        while (nodoB != null) {
            nuevoConjunto.insertar(nodoB.getDato(), nodoB.getEtiqueta());
            nodoB = nodoB.getSiguiente();
        }

        return nuevoConjunto;
    }

    public Conjunto<T> interseccion(Conjunto<T> conjuntoB) {
        Conjunto<T> nuevoConjunto = new Conjunto<>();
        TDANodo<T> nodoA = this.getPrimero();
        TDANodo<T> nodoB = conjuntoB.getPrimero();

        while (nodoA != null && nodoB != null) {
            if (nodoA.getEtiqueta().compareTo(nodoB.getEtiqueta()) < 0) {
                nodoA = nodoA.getSiguiente();
            } else if (nodoA.getEtiqueta().compareTo(nodoB.getEtiqueta()) > 0) {
                nodoB = nodoB.getSiguiente();
            } else {
                nuevoConjunto.insertar(nodoA.getDato(), nodoA.getEtiqueta());
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            }
        }

        return nuevoConjunto;
    }
}
