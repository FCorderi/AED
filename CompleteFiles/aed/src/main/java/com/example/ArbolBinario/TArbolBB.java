package com.example.ArbolBinario;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (!esVacio()) {
            return raiz.insertar(unElemento);
        }
        raiz = unElemento;
        return true;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    @Override
    public String preOrden() {
        if (!esVacio()) {
            return raiz.preOrden();
        }
        return null;
    }

    @Override
    public String inOrden() {
        if (!esVacio()) {
            return raiz.inOrden();
        }
        return null;
    }

    @Override
    public String postOrden() {
        if (!esVacio()) {
            return raiz.postOrden();
        }
        return null;
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
