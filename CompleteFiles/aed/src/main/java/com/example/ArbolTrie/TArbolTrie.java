package com.example.ArbolTrie;

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    public boolean esVacio(){
        return raiz == null;
    }

    @Override
    public void insertar(String palabra) {
        if (esVacio()) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void insertar(String palabra, LinkedList<Integer> paginas) {
        if (esVacio()) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra, paginas);
    }

    @Override
    public void imprimir() {
        if (esVacio()) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscarComparaciones(String palabra) {
        if (raiz == null) {
            return 0;
        }
        return raiz.buscarComparaciones(palabra);
    }

    @Override
    public String buscar(String palabra){
        if (!esVacio()) {
            return raiz.buscar(palabra);
        }
        return "";
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> listaResultado= new LinkedList<String>();
        if (raiz == null) {
            return null;
        }
        raiz.predecir(prefijo, listaResultado);
        return listaResultado;
    }
    
    public LinkedList<Integer> buscarPaginas(String palabra) {
        if (!esVacio()) {
            return raiz.buscarPaginas(palabra);
        }
        return null;
    }
    
}
