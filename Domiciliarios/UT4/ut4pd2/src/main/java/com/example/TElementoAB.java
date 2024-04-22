package com.example;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (this.etiqueta.equals(unaEtiqueta)) {
            return this;
        }
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta);
            }
        } else {
            if (hijoDer != null) {
                return hijoDer.buscar(unaEtiqueta);
            }
        }
        return null;
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (elemento.etiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null)
                return hijoIzq.insertar(elemento);
            else {
                hijoIzq = elemento;
                return true;
            }
        } else if (elemento.etiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null)
                return hijoDer.insertar(elemento);
            else {
                hijoDer = elemento;
                return true;
            }
        }
        return false;
    }

    @Override
    public String preOrden() {
        String res = datos.toString() + " ";
        if (hijoIzq != null) {
            res += hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            res += hijoDer.preOrden();
        }
        return res;
    }

    @Override
    public String inOrden() {
        String res = "";
        if (hijoIzq != null) {
            res += hijoIzq.inOrden();
        }
        res += datos.toString() + " ";
        if (hijoDer != null) {
            res += hijoDer.inOrden();
        }
        return res;
    }

    @Override
    public String postOrden() {
        String res = "";
        if (hijoIzq != null) {
            res += hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            res += hijoDer.postOrden();
        }
        res += datos.toString() + " ";
        return res;
    }

    @Override
    public T getDatos() {
        return datos;

    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
}