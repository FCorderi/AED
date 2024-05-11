package com.example.ArbolBinario;

import java.util.List;

@SuppressWarnings({ "rawtypes" })
public interface IArbolBB<T> {

  /**
   * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
   * clave indicada en "unElemento", retorna falso.
   *
   * @param unElemento Elemento a insertar
   * @return Exito de la operacián
   */

  public boolean insertar(TElementoAB<T> unElemento);

  /**
   * Busca un elemento dentro del árbol.
   *
   *
   * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
   *                    .
   * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
   */
  public TElementoAB<T> buscar(Comparable unaEtiqueta);

  /**
   * Imprime en PreOrden los elementos del árbol, separados por guiones.
   *
   * @return String conteniendo el preorden separado por guiones.
   */
  public String preOrdenString();

  /**
   * Realiza un recorrido en preorden del árbol.
   *
   * @return Una lista con los elementos del recorrido en preorden.
   */
  public List<T> preOrden();

  /**
   * Imprime en InOrden los elementos del árbol, separados por guiones.
   *
   * @return String conteniendo el preorden separado por guiones.
   */
  public String inOrdenString();

  /**
   * Devuelve en InOrden los elementos del árbol, guardados en una LinkedList.
   *
   * @return LinkedList conteniendo el Inorden.
   */
  public List<T> inOrden();

  /**
   * Imprime en PostOrden los elementos del árbol, separados por guiones.
   *
   * @return String conteniendo el preorden separado por guiones.
   */
  public String postOrdenString();

  /**
     * Realiza un recorrido en postorden del árbol.
     *
     * @return Una lista con los elementos del recorrido en postorden.
     */
    public List<T> postOrden();

  /**
   * Elimina un elemento dada una etiqueta.
   * 
   * @param unaEtiqueta
   */
  public void eliminar(Comparable unaEtiqueta);

}
