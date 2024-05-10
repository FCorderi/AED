package ut5;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        
        imprimir("", this);
    }
    
      private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
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
            } else {
                nodo = nodo.hijos[indice];
            }
        }
        predecir(prefijo, palabras, nodo);
    }

    @Override
    public int buscar(String s) {
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
  
}
