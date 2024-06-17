package ut3;

import java.util.LinkedList;
public class Sucursales {

    private LinkedList<String> sucursales;

    public Sucursales (){
        sucursales = new LinkedList<String>();
    }
    public void agregarSucursal(String sucursal) {
        sucursales.add(sucursal);
    }

    public String buscarSucursal(String sucursal) {
        int index = sucursales.indexOf(sucursal);
        return sucursales.get(index).toString();
    }

    public void quitarSucursal(String sucursal) {
        sucursales.remove(sucursal);
    }

    public void listarSucursales() {
        for (int i = 0; i < sucursales.size(); i++) {
            System.out.println(sucursales.get(i));
        }
    }

    public int cantSucursales(){
        return sucursales.size();
    }

    public boolean esVacio(){
        return sucursales.isEmpty();
    }

}
