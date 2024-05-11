package com.example.ArbolBinario;

import java.util.List;

import com.example.ArbolAVL.TElementoAVL;

import java.util.LinkedList;

@SuppressWarnings({"rawtypes"})
/**
 * Clase que representa un árbol binario de búsqueda (ABB). En un ABB, para cualquier nodo, todos los elementos
 * en el subárbol izquierdo son menores que el elemento en el nodo y todos los elementos en el subárbol derecho
 * son mayores.
 *
 * @param <T> El tipo de los datos que contendrán los elementos del árbol.
 */
public class TArbolBB<T> implements IArbolBB<T> {

    /**
     * Nodo raíz del árbol binario de búsqueda.
     */
    protected TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    /**
     * Constructor por defecto de la clase TArbolBB. Crea un árbol vacío.
     */
    public TArbolBB() {
        raiz = null;
    }

    /**
     * Obtiene el nodo raíz del árbol.
     *
     * @return Nodo raíz del árbol.
     */
    
    public TElementoAB<T> getRaiz() {
        return (TElementoAB<T>) raiz;
    }

    /**
     * Verifica si el árbol está vacío (sin elementos).
     *
     * @return Verdadero si el árbol está vacío, falso en caso contrario.
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * Elimina todos los elementos del árbol.
     *
     * @return Verdadero si había elementos y el árbol fue vaciado, falso si el árbol ya estaba vacío.
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    /**
     * Inserta un elemento en el árbol. Si el árbol no contiene un elemento con la
     * misma etiqueta, se inserta y retorna verdadero. Si ya existe, no se inserta y retorna falso.
     *
     * @param unElemento    elemento a insertar.
     * @return Verdadero si el elemento fue insertado correctamente, falso en caso contrario.
     */
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (!esVacio()) {
            return raiz.insertar(unElemento);
        }
        raiz = unElemento;
        return true;
    }

    /**
     * Inserta un elemento en el árbol. Si el árbol no contiene un elemento con la
     * misma etiqueta, se inserta y retorna verdadero. Si ya existe, no se inserta y retorna falso.
     *
     * @param etiqueta Etiqueta del elemento a insertar.
     * @param unDato   Datos del elemento a insertar.
     * @return Verdadero si el elemento fue insertado correctamente, falso en caso contrario.
     */
    public boolean insertar(Comparable etiqueta, T unDato) {
        TElementoAB<T> unElemento = new TElementoAB<>(etiqueta, unDato);
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * Busca un elemento en el árbol utilizando su etiqueta.
     *
     * @param unaEtiqueta Etiqueta del elemento a buscar.
     * @return El elemento encontrado. Si no se encuentra, retorna nulo.
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    @Override
    public String preOrdenString() {
        if (!esVacio()) {
            return raiz.preOrden();
        }
        return null;
    }

    /**
     * Devuelve una lista de los elementos del árbol en preorden (raíz, izquierda, derecha).
     *
     * @return Lista con los elementos del árbol en preorden.
     */
    @Override
    public List<T> preOrden() {
        LinkedList<T> listaPreOrden = null;
        if (!esVacio()) {
            listaPreOrden = new LinkedList<>();
            raiz.preOrden(listaPreOrden);
        }
        return listaPreOrden;
    }

    @Override
    public String inOrdenString() {
        if (!esVacio()) {
            return raiz.inOrden();
        }
        return null;
    }

    @Override
    public List<T> inOrden() {
        LinkedList<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new LinkedList<>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;
    }

    @Override
    public String postOrdenString() {
        if (!esVacio()) {
            return raiz.postOrden();
        }
        return null;
    }

    /**
     * Devuelve una lista de los elementos del árbol en postorden (izquierda, derecha, raíz).
     *
     * @return Lista con los elementos del árbol en postorden.
     */
    @Override
    public List<T> postOrden() {
        LinkedList<T> listaPostOrden = null;
        if (!esVacio()) {
            listaPostOrden = new LinkedList<>();
            raiz.postOrden(listaPostOrden);
        }
        return listaPostOrden;
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            raiz.eliminar(unaEtiqueta);
        }
    }

    public int obtenerCantidadHojas() {
        if (esVacio()) {
            return 0;
        } else
            return raiz.obtenerCantidadHojas();

    }

    public int contarNodosNivel(int nivel) {
        if (esVacio()) {
            return 0;
        }
        return raiz.contarNodosNivel(nivel);

    }

    public Comparable obtenerMenorClave() {
        if (esVacio()) {
            return null;
        }
        return raiz.obtenerMenorClave();

    }

    public Comparable obtenerMayorClave() {
        if (esVacio()) {
            return null;
        }
        return raiz.obtenerMayorClave();

    }

    public Comparable obtenerInmediatoAnterior(Comparable unaClave) {
        if (esVacio()) {
            return null;
        }
        return raiz.obtenerInmediatoAnterior(unaClave);

    }

    public String listarHojasConNiveles() {
        if (esVacio()) {
            return "";
        } else {
            return raiz.listarHojasConNiveles(0);
        }
    }

    public boolean esDeBusqueda() {
        if (esVacio()) {
            return true;
        }
        return raiz.esDeBusqueda();

    }

}
