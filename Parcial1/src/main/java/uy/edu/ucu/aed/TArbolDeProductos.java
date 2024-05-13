package uy.edu.ucu.aed;

public class TArbolDeProductos extends TArbolBB<Producto> {
    public TArbolDeProductos(){
        super();
    }

    public double longIntMed(){
        if (esVacio()){
            return -1;
        }
        int n = obtenerTamaño();
        return raiz.longTraInt(0) / n;
    }

    public int obtenerTamaño(){
        if (esVacio()){
            return 0;
        }
        return raiz.obtenerTamaño();
    }

    
}
