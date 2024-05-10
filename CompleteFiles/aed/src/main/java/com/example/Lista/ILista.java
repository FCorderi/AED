package com.example.Lista;

public interface ILista<T> {

    /**
     * Agrega un nuevo nodo al final de la lista.
     *
     * @param dato  - El valor que se almacenará en el nuevo nodo.
     * @param clave - La clave única que identificará al nuevo nodo.
     */
    public void insertar(T dato, Comparable clave);

    /**
     * Metodo encargado de agregar un nodo al final de la lista.
     *
     * @param nodo - Nodo a agregar
     */
    public void insertar(TDANodo<T> nodo);

    /**
     * Metodo encargado de buscar un nodo cuya clave es la indicada.
     *
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public TDANodo<T> buscar(Comparable clave);

    /**
     * Metodo encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminaci�n haya sido efectuada con �xito.
     */
    public boolean eliminar(Comparable clave);

    /**
     * Metodo encargado de imprimir en consola las claves de los nodos
     * contenidos en la lista.
     * @return 
     */
    public String imprimir();

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * par�metro.
     *
     * @param separador Separa las claves
     * @return
     */
    public String imprimir(String separador);

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vac�a, retornar 0.
     *
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos();

    /**
     * Cambia la cantidad de nodos en la lista
     * 
     */
    public void setCantElementos(int cantElementos);

    /**
     * Indica si la lista contiene o no elementos.
     *
     * @return Si tiene elementos o no.
     */
    public boolean esVacia();
    
    /**
     * Establece el primer nodo de la lista.
     *
     * @param unNodo - El nodo que se establecerá como el primero en la lista.
     */
    public void setPrimero( TDANodo<T> unNodo);   
    
    /**
     * Obtiene el primer nodo de la lista.
     *
     * @return El primer nodo de la lista.
     */
    public TDANodo<T> getPrimero();

}
