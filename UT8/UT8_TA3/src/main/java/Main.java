import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        TGrafoNoDirigido grafo = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("src\\main\\java\\verticesBEA.txt", "src\\main\\java\\aristasBEA.txt",
                false, TGrafoNoDirigido.class);
        System.out.println("Grafo cargado en memoria");

        System.out.println("Busqueda en amplitud: Sin vertice especificado");
        Iterator<TVertice> it = grafo.bea().iterator();
        while (it.hasNext()) {
            TVertice v = it.next();
            System.out.println(v.getEtiqueta());
        }






    }
}
