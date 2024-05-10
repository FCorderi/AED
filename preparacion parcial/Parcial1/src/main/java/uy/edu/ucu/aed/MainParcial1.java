package uy.edu.ucu.aed;

/**
 * Parcial 1
 *
 */
public class MainParcial1 
{
    public static void main( String[] args )
    {
        String[] test = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\uy\\edu\\ucu\\aed\\test.txt");
        for (String p : test){
            System.out.println(p);
        }
    }
}
