
package com.example.Lista;

public class TDANodo<T> implements INodo {

    private Comparable etiqueta;
    private T dato;
    private TDANodo<T> siguiente = null;

    public TDANodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    public void setDato(T nuevoDato) {
        this.dato = nuevoDato;
    }

    @Override
    public TDANodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(TDANodo nodo) {
        this.siguiente = nodo;
    }

    @Override
    public void imprimir() {
        System.out.print(getDato().toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    public TDANodo<T> clonar() {
        return new TDANodo<T>(this.etiqueta, this.dato);
    }

    public boolean equals(TDANodo<T> unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

}
