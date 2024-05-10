package com.example.Lista;

public class TDALista<T> implements ILista<T> {

    private TDANodo<T> primero;
    private int cantElementos;

    public TDALista() {
        primero = null;
        cantElementos = 0;
    }

    public TDANodo<T> getPrimero() {
        return this.primero;
    }

    @Override
    public void setPrimero(TDANodo<T> unNodo) {
        if (esVacia()) {
            this.primero = unNodo;
        } else {
            unNodo.setSiguiente(this.primero.getSiguiente());
            this.primero = unNodo;
        }
    }

    public int getCantElementos() {
        return cantElementos;
    }

    @Override
    public void setCantElementos(int nuevaCantElementos) {
        this.cantElementos = nuevaCantElementos;
    }

    public void insertar(TDANodo<T>[] listaNodos) {
        for (TDANodo<T> nodo : listaNodos) {
            insertar(nodo);
        }
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        TDANodo<T> nuevoNodo = new TDANodo<T>(clave, dato);

        insertar(nuevoNodo);
    }

    @Override
    public void insertar(TDANodo<T> nodo) {
        TDANodo<T> nodoActual = this.primero;
        if (nodoActual == null) {
            primero = nodo;
        } else {
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nodo);
        }
    }

    @Override
    public TDANodo<T> buscar(Comparable clave) {
        TDANodo<T> nodoActual = this.primero;
        if (nodoActual == null) {
            return null;
        } else {
            while (nodoActual != null) {
                if (nodoActual.compareTo(clave) == 0) {
                    return nodoActual;
                } else {
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (this.primero == null) {
            return false;
        } else {
            TDANodo<T> nodoAEliminar;
            if (this.primero.compareTo(clave) == 0) {
                nodoAEliminar = this.primero;
                this.primero = this.primero.getSiguiente();
                nodoAEliminar.setSiguiente(null);
                return true;
            } else {
                TDANodo<T> nodoActual = primero;
                while (nodoActual.getSiguiente() != null) {
                    if (nodoActual.getSiguiente().compareTo(clave) == 0) {
                        nodoAEliminar = nodoActual.getSiguiente();
                        nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
                        nodoAEliminar.setSiguiente(null);
                        return true;
                    } else {
                        nodoActual = nodoActual.getSiguiente();
                    }
                }
            }
            return false;
        }
    }

    @Override
    public String imprimir() {
        if (this.primero == null) {
            System.out.println("[]");
            return "[]";
        } else {
            StringBuilder lista = new StringBuilder("[");
            TDANodo<T> nodoActual = this.primero;
            while (nodoActual != null) {
                lista.append(nodoActual.getEtiqueta());
                if (nodoActual.getSiguiente() != null) {
                    lista.append(", ");
                } else {
                    lista.append("]");
                }
                nodoActual = nodoActual.getSiguiente();
            }
            System.out.println(lista);
            return lista.toString();
        }
    }

    @Override
    public String imprimir(String separador) {
        if (this.primero == null) {
            System.out.println("[]");
            return "[]";
        } else {
            StringBuilder lista = new StringBuilder("[");
            TDANodo<T> nodoActual = this.primero;
            while (nodoActual != null) {
                lista.append(nodoActual.getEtiqueta());
                if (nodoActual.getSiguiente() != null) {
                    lista.append(separador);
                } else {
                    lista.append("]");
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return lista.toString();
        }
    }

    @Override
    public int cantElementos() {
        if (this.esVacia()) {
            return 0;
        } else {
            TDANodo<T> nodoActual = this.primero;
            int contador = 1;
            while (nodoActual.getSiguiente() != null) {
                ++contador;
                nodoActual = nodoActual.getSiguiente();
            }
            setCantElementos(contador);
            return contador;
        }
    }

    @Override
    public boolean esVacia() {
        return this.primero == null;
    }
}
