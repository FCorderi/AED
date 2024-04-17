package com.example.Lista;

public class TDALista<T> implements ILista{
    
    private TDANodo<T> primero;
    
    @Override
    public void insertar(TDANodo nodo) {
        if (this.primero == null) {
            primero = nodo;
        } else {
            TDANodo nodoActual = this.primero;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nodo);
        }
    }

    @Override
    public TDANodo buscar(Comparable clave) {
       if (this.primero == null) {
           return null;
       } else {
           TDANodo nodoActual = this.primero;
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
            TDANodo nodoAEliminar;
            if (this.primero.compareTo(clave) == 0){
                nodoAEliminar = this.primero;
                this.primero = this.primero.getSiguiente();
                nodoAEliminar.setSiguiente(null);
                return true;
            } else {
                TDANodo nodoActual = primero;
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
        }else {
            StringBuilder lista = new StringBuilder("[");
            TDANodo nodoActual = this.primero;
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
        }else {
            StringBuilder lista = new StringBuilder("[");
            TDANodo nodoActual = this.primero;
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
           TDANodo nodoActual = this.primero;
           int contador = 1;
           while (nodoActual.getSiguiente() != null) {
               ++contador;
               nodoActual = nodoActual.getSiguiente();
            }
           return contador;
       } 
    }

    @Override
    public boolean esVacia() {
        return this.primero == null;
    }

    @Override
    public void setPrimero(TDANodo unNodo) {
        unNodo.setSiguiente(this.primero.getSiguiente());
        this.primero = unNodo;    
    }
    
}
