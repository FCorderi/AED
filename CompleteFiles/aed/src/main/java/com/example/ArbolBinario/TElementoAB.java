package com.example.ArbolBinario;

import java.util.List;
import java.util.LinkedList;

@SuppressWarnings({"rawtypes", "unchecked"})
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

    /**
     * Realiza un recorrido preorden del subárbol cuya raíz es el nodo actual y agrega los datos de los
     * elementos a una lista pasada como parámetro.
     *
     * @param unaLista Lista donde se agregarán los datos de los elementos en preorden.
     */
    @Override
    public void preOrden(LinkedList<T> unaLista) {
        unaLista.add(this.getDatos());
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }
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
    public void inOrden(LinkedList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        unaLista.add(this.getDatos());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
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

    /**
     * Realiza un recorrido postorden del subárbol cuya raíz es el nodo actual y agrega los datos de los
     * elementos a una lista pasada como parámetro.
     *
     * @param unaLista Lista donde se agregarán los datos de los elementos en postorden.
     */
    @Override
    public void postOrden(LinkedList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.add(this.getDatos());
    }

    @Override
    public T getDatos() {
        return datos;

    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        } else {
            return quitaElNodo();
        }
    }

    private TElementoAB quitaElNodo() {
        if (hijoIzq == null) {
            return hijoDer;
        }
        if (hijoDer == null) {
            return hijoIzq;
        }
        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;
        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        if (elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }
        elHijo.hijoDer = hijoDer;
        return elHijo;
    }

    public int obtenerCantidadHojas() {
        int hojas = 0;
        boolean esHoja = true;
        if (hijoIzq != null) {
            hojas = hojas + hijoIzq.obtenerCantidadHojas();
            esHoja = false;
        }
        if (hijoDer != null) {
            hojas = hojas + hijoDer.obtenerCantidadHojas();
            esHoja = false;
        }
        if (esHoja) {
            return 1;
        } else {
            return hojas;
        }
    }

    public int contarNodosNivel(int nivel) {
        int sumaNodosNivel = 0;
        if (nivel == 0) {
            return 1;
        }
        if (hijoIzq != null) {
            sumaNodosNivel += hijoIzq.contarNodosNivel(nivel - 1);
        }
        if (hijoDer != null) {
            sumaNodosNivel += hijoDer.contarNodosNivel(nivel - 1);
        }
        return sumaNodosNivel;
    }

    public Comparable obtenerMenorClave() {
        Comparable claveMenor = this.etiqueta;
        if (hijoIzq != null) {
            claveMenor = hijoIzq.obtenerMenorClave();
        }
        return claveMenor;
    }

    public Comparable obtenerMayorClave() {
        Comparable claveMayor = this.etiqueta;
        if (hijoDer != null) {
            claveMayor = hijoDer.obtenerMayorClave();
        }
        return claveMayor;
    }

    public Comparable obtenerInmediatoAnterior(Comparable unaClave) {
        String[] arregloDeClaves = this.inOrden().split(" ");
        int contador = 0;
        Comparable clave;
        while (contador < arregloDeClaves.length) {
            clave = Integer.parseInt(arregloDeClaves[contador]);
            if (clave.compareTo(unaClave) == 0) {
                if (contador > 0) {
                    return Integer.parseInt(arregloDeClaves[contador - 1]);
                } else {
                    return null;
                }
            }
            contador++;
        }
        return null;
    }

    public String listarHojasConNiveles(int nivelDelNodo) {
        StringBuilder lista = new StringBuilder("");
        boolean esHoja = true;
        if (hijoIzq != null) {
            lista.append(hijoIzq.listarHojasConNiveles(nivelDelNodo + 1));
            esHoja = false;
        }
        if (hijoDer != null) {
            if (lista.equals("")) {
                lista.append(hijoDer.listarHojasConNiveles(nivelDelNodo + 1));
            } else {
                lista.append("\n" + hijoDer.listarHojasConNiveles(nivelDelNodo + 1));
            }
            esHoja = false;
        }
        if (esHoja) {
            return etiqueta.toString() + " Nivel: " + nivelDelNodo;
        } else {
            return lista.toString();
        }
    }

    public boolean esDeBusqueda() {
        boolean esBusqueda = true;
        if (hijoIzq != null) {
            if (hijoIzq.etiqueta.compareTo(etiqueta) < 0) {
                esBusqueda = hijoIzq.esDeBusqueda();
                if (!esBusqueda) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (hijoDer != null) {
            if (hijoDer.etiqueta.compareTo(etiqueta) > 0) {
                esBusqueda = hijoDer.esDeBusqueda();
                if (!esBusqueda) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return esBusqueda;
    }
}
