package com.example.ArbolTrie;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas = new LinkedList();

    }

    public LinkedList<Integer> getPaginas() {
        return this.paginas;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int i = 0; i < unaPalabra.length(); i++) {
            int indice = unaPalabra.charAt(i) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    @Override
    public void insertar(String unaPalabra, LinkedList<Integer> paginasPalabra) {
        unaPalabra = unaPalabra.toLowerCase();
        TNodoTrie nodo = this;
        for (int i = 0; i < unaPalabra.length(); i++) {
            int indice = unaPalabra.charAt(i) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        for (Integer i : paginasPalabra) {
            nodo.getPaginas().addFirst(i);
        }
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        s = s.toLowerCase();
        TNodoTrie nodo = this;
        for (int i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    private void predecir(String s, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo.esPalabra) {
            palabras.add(s);
        }
        for (int i = 0; i < CANT_CHR_ABECEDARIO; i++) {
            if (nodo.hijos[i] != null) {
                predecir(s + (char) (i + 'a'), palabras, nodo.hijos[i]);
            }
        }

    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        prefijo = prefijo.toLowerCase();
        TNodoTrie nodo = this;
        for (int i = 0; i < prefijo.length(); i++) {
            int indice = prefijo.charAt(i) - 'a';
            if (nodo.hijos[indice] == null) {
                return;
            }
            nodo = nodo.hijos[indice];
        }
        predecir(prefijo, palabras, nodo);
    }

    @Override
    public int buscarComparaciones(String s) {
        s = s.toLowerCase();
        TNodoTrie nodo = this;
        int contador = 0;
        for (int i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';
            if (nodo.hijos[indice] == null) {
                return 0;
            } else {
                nodo = nodo.hijos[indice];
                contador++;
            }

        }
        if (nodo.esPalabra) {
            return contador + 1;
        } else {
            return 0;
        }
    }

    @Override
    public String buscar(String s) {
        s = s.toLowerCase();
        TNodoTrie nodoActual = this;
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';
            if (nodoActual.hijos[indice] == null) {
                return "La palabra " + s + " no existe en el indice. Cantidad de comparaciones realizadas: " + (i + 1);
            }
            nodoActual = nodoActual.hijos[indice];
        }
        if (nodoActual.esPalabra) {
            StringBuilder mensaje = new StringBuilder("Palabra: ");
            mensaje.append(s);
            mensaje.append(", Paginas en la que se encuetra: ");
            for (Integer a : nodoActual.getPaginas()) {
                mensaje.append(a).append(" ");
            }
            return mensaje.toString();
        }
        return "La palabra no existe en el indice. Cantidad de comparaciones realizadas: " + (i + 1);
    }

    public LinkedList<Integer> buscarPaginas(String s) {
        s = s.toLowerCase();
        TNodoTrie nodoActual = this;
        for (int i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';
            if (nodoActual.hijos[indice] == null) {
                return null;
            }
            nodoActual = nodoActual.hijos[indice];
        }
        if (nodoActual.esPalabra) {
            return nodoActual.getPaginas();
        }
        return null;
    }

}
