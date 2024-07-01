package TemplateGrafos.src.main.java.uy.edu.ucu.aed;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos.txt","./src/conexiones.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        
        boolean[][] mWarshall = gd.warshall();
        
        int rows = mWarshall.length;
        int cols = mWarshall[0].length;
        Double[][] mWarshallDouble = new Double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mWarshall[i][j]) {
                    mWarshallDouble[i][j] = 1.0;
                } else {
                    mWarshallDouble[i][j] = 0.0;
                }
            }
        }
        UtilGrafos.imprimirMatrizMejorado(mWarshallDouble, gd.getVertices(), "Matriz luego de FLOYD");
        
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        
        
        
        System.out.println();
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());
        
        
        TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/verticesBEA.txt","./src/aristasBEA.txt",
                false, TGrafoNoDirigido.class);
        gnd = gnd.Kruskal();
        Double[][] gndMatriz = UtilGrafos.obtenerMatrizCostos(gnd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(gndMatriz, gnd.getVertices(), "Matriz luego de KRUSKAL");
        
        TGrafoNoDirigido gnd2 = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/verticesBEA.txt","./src/aristasBEA.txt",
                false, TGrafoNoDirigido.class);
        gnd2 = gnd2.Prim();
        Double[][] gnd2Matriz = UtilGrafos.obtenerMatrizCostos(gnd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(gnd2Matriz, gnd.getVertices(), "Matriz luego de PRIM");
       
       
    }
}
