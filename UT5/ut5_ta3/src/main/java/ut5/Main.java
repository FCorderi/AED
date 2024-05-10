package ut5;
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        // trie.imprimir();  
             
        LinkedList<String> lista=trie.predecir("ar");
        for (String p : lista) {
            System.out.println(p);
        }
    }
}