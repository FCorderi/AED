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
        if (raiz != null) {
            return raiz.insertar(unElemento);
        }
        raiz = unElemento;
        return true;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (raiz != null) {
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    @Override
    public String preOrden() {
        if (raiz != null) {
            return raiz.preOrden();
        }
        return null;
    }

    @Override
    public String inOrden() {
        if (raiz != null) {
            return raiz.inOrden();
        }
        return null;
    }

    @Override
    public String postOrden() {
        if (raiz != null) {
            return raiz.postOrden();
        }
        return null;
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz.eliminar(unaEtiqueta);
        }
    }

    public int obtenerCantidadHojas() {
        if(esVacio()){
            return 0;
        }else{
            return raiz.obtenerCantidadHojas();
        }
    }

}
