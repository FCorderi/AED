
package com.example;

public class TDANodo<T> implements INodo{
    
    private Comparable etiqueta;
    private T dato;
    private TDANodo<T> siguiente = null;
    
    public TDANodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    @Override
    public Object getDato() {
        return this.dato;
    }

    @Override
    public TDANodo getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(TDANodo nodo) {
        this.siguiente = nodo;
    }


    @Override
    public void imprimir() {
        System.out.print(this.dato);
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
    
}
