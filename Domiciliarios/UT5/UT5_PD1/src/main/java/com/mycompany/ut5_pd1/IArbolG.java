/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ut5_pd1;

/**
 *
 * @author matia
 */
public interface IArbolG {
    
    public boolean insertar(Comparable etiqueta, Comparable etiquetaPadre);
    
    public TNodoArbolGenerico buscar(Comparable etiqueta);
    
    public String listarIdentado();
    
    public boolean esVacio();
            
}
