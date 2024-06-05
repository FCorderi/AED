/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ut5_pd1;

/**
 *
 * @author matia
 */
public class TNodoArbolGenerico implements INodoArbolGenerico{
    
    private Comparable etiqueta;
    private TNodoArbolGenerico hijo;
    private TNodoArbolGenerico hermanoIzquierdo;
    
    public TNodoArbolGenerico(Comparable etiqueta){
        this.etiqueta = etiqueta;
        this.hijo = null;
        this.hermanoIzquierdo = null;
    }
    
    public String preOrden(){
        StringBuilder listaPreOrden = new StringBuilder();
        listaPreOrden.append(this.etiqueta + " ");
        TNodoArbolGenerico unHijo = this.hijo;
        while (unHijo != null){
            listaPreOrden.append(unHijo.preOrden());
            unHijo = unHijo.getHermano();
        }
        return listaPreOrden.toString();
    }
    
    public String inOrden(){
        StringBuilder listaPreOrden = new StringBuilder();
        TNodoArbolGenerico unHijo = this.hijo;
        if(unHijo == null){
            listaPreOrden.append(this.etiqueta + " ");
        }else{
            int contador = 0;
            while (unHijo != null){
            contador++;
            listaPreOrden.append(unHijo.inOrden());
            if(contador == 1){
                listaPreOrden.append(this.etiqueta + " ");
            }
            unHijo = unHijo.getHermano();
            }
        }
        return listaPreOrden.toString();
    }
    
    public String postOrden(){
        StringBuilder listaPreOrden = new StringBuilder();
        TNodoArbolGenerico unHijo = this.hijo;
        while (unHijo != null){
            listaPreOrden.append(unHijo.postOrden());
            unHijo = unHijo.getHermano();
        }
        listaPreOrden.append(this.etiqueta + " ");
        return listaPreOrden.toString();
    }

    @Override
    public boolean insertar(Comparable etiqueta, Comparable etiquetaPadre) {
        if(buscar(etiqueta) != null){
            return false;
        }
        TNodoArbolGenerico elPadre = buscar(etiquetaPadre);
        TNodoArbolGenerico nuevoNodo = new TNodoArbolGenerico(etiqueta);
        if (elPadre != null){
            nuevoNodo.setHermano(elPadre.getHijo());
            elPadre.setHijo(nuevoNodo);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public TNodoArbolGenerico buscar(Comparable etiqueta) {
        if (this.etiqueta.equals(etiqueta)){
            return this;
        }else{
            TNodoArbolGenerico unHijo = this.hijo;
            TNodoArbolGenerico resultado;
            while (unHijo != null){
                resultado = unHijo.buscar(etiqueta);
                if(resultado != null){
                    return resultado;
                }
                unHijo = unHijo.getHermano();
            }
            return null;
        }
    }

    @Override
    public String listarIdentado(int nivel) {
        StringBuilder lista = new StringBuilder();
        if( nivel != 0){
            lista.append("    ".repeat(nivel));
        }
        lista.append(this.etiqueta).append("\n");
        TNodoArbolGenerico unHijo = this.hijo;
        while (unHijo != null){
            lista.append(unHijo.listarIdentado(nivel + 1));
            unHijo = unHijo.getHermano();
        }
        return lista.toString();
    }
    
    public void setHijo(TNodoArbolGenerico nodo){
        this.hijo = nodo;
    }
    
    public TNodoArbolGenerico getHijo(){
        return this.hijo;
    }
    
    public void setHermano(TNodoArbolGenerico nodo){
        this.hermanoIzquierdo = nodo;
    }
    
    public TNodoArbolGenerico getHermano(){
        return this.hermanoIzquierdo;
    }
    
    public Comparable getEtiqueta(){
        return this.etiqueta;
    }
    
}
