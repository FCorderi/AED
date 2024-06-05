/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.ut5_pd1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author matia
 */
public class TArbolGenericoTest {
    
    public TArbolGenericoTest() {
    }

    /**
     * Test of insertar method, of class TArbolGenerico.
     */
    @Test
    public void testInsertarArbolVacioYSinEtiquetaPadre() {
        System.out.println("insertar");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        assertFalse(arbol.insertar(0, 2));
        assertTrue(arbol.esVacio());  
    }
    
    /**
     * Test of insertar method, of class TArbolGenerico.
     */
    @Test
    public void testInsertarArbolVacioYConEtiquetaPadre() {
        System.out.println("insertar");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        assertTrue(arbol.insertar(0, ""));
        assertFalse(arbol.esVacio());  
    }
    
    /**
     * Test of insertar method, of class TArbolGenerico.
     */
    @Test
    public void testInsertarArbolConElementos() {
        System.out.println("insertar");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        assertTrue(arbol.insertar(0, ""));
        assertTrue(arbol.insertar(1, 0));
        assertEquals(1, arbol.buscar(0).getHijo().getEtiqueta());
    }
    
    /**
     * Test of insertar method, of class TArbolGenerico.
     */
    @Test
    public void testInsertarArbolConElementosYNuevaEtiquetaPadre() {
        System.out.println("insertar");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        assertTrue(arbol.insertar(0, ""));
        assertTrue(arbol.insertar(1, 0));
        assertTrue(arbol.insertar(2, ""));
        assertEquals(2, arbol.raiz.getEtiqueta());
    }
    
    /**
     * Test of insertar method, of class TArbolGenerico.
     */
    @Test
    public void testInsertarArbolConElementosYConEtiquetaYaPresente() {
        System.out.println("insertar");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        assertTrue(arbol.insertar(0, ""));
        assertTrue(arbol.insertar(1, 0));
        assertTrue(arbol.insertar(2, 1));
        assertFalse(arbol.insertar(1, 2));
    }

    /**
     * Test of buscar method, of class TArbolGenerico.
     */
    @Test
    public void testBuscarArbolVacio() {
        System.out.println("buscar");
        
        TArbolGenerico arbol = new TArbolGenerico();

        assertNull(arbol.buscar(5));  
    }
    
    /**
     * Test of buscar method, of class TArbolGenerico.
     */
    @Test
    public void testBuscarArbolConElementosPeroSinEtiqueta() {
        System.out.println("buscar");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        arbol.insertar(0, "");
        arbol.insertar(1, 0);
        arbol.insertar(2, 0);
        arbol.insertar(3, 2);
   
        assertNull(arbol.buscar(5));   
    }
    
    /**
     * Test of buscar method, of class TArbolGenerico.
     */
    @Test
    public void testBuscarArbolConElementosYEtiqueta() {
        System.out.println("buscar");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        arbol.insertar(0, "");
        arbol.insertar(1, 0);
        arbol.insertar(2, 0);
        arbol.insertar(3, 2);
   
        assertEquals(2, arbol.buscar(2).getEtiqueta());   
    }
    
        /**
     * Test of buscar method, of class TArbolGenerico.
     */
    @Test
    public void testBuscarArbolInmutado() {
        System.out.println("buscar");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        arbol.insertar(0, "");
        arbol.insertar(1, 0);
        arbol.insertar(2, 0);
        arbol.insertar(3, 2);
        
        String postOrdenAntes = arbol.postOrden();
        String inOrdenAntes = arbol.inOrden();
        
        arbol.buscar(2);  
        
        String postOrdenDespues = arbol.postOrden();
        String inOrdenDespues = arbol.inOrden();
        
        assertEquals(postOrdenAntes, postOrdenDespues);
        assertEquals(inOrdenAntes, inOrdenDespues);
    }

    /**
     * Test of listarIdentado method, of class TArbolGenerico.
     */
    @Test
    public void testListarIdentadoArbolVacio() {
        System.out.println("listarIdentado");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        assertEquals("", arbol.listarIdentado());
    }
    
    /**
     * Test of listarIdentado method, of class TArbolGenerico.
     */
    @Test
    public void testListarIdentadoArbolConElementos() {
        System.out.println("listarIdentado");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        arbol.insertar(0, "");
        arbol.insertar(1, 0);
        arbol.insertar(2, 0);
        arbol.insertar(3, 2);
        
        String mensaje = "0\n    2\n        3\n    1\n";
        
        assertEquals(mensaje, arbol.listarIdentado());
    }
    
        
    /**
     * Test of listarIdentado method, of class TArbolGenerico.
     */
    @Test
    public void testListarIdentadoArbolInmutado() {
        System.out.println("listarIdentado");
        
        TArbolGenerico arbol = new TArbolGenerico();
        
        arbol.insertar(0, "");
        arbol.insertar(1, 0);
        arbol.insertar(2, 0);
        arbol.insertar(3, 2);
        
        String postOrdenAntes = arbol.postOrden();
        String inOrdenAntes = arbol.inOrden();
        
        arbol.listarIdentado();  
        
        String postOrdenDespues = arbol.postOrden();
        String inOrdenDespues = arbol.inOrden();
        
        assertEquals(postOrdenAntes, postOrdenDespues);
        assertEquals(inOrdenAntes, inOrdenDespues);
    }
    
    
}
