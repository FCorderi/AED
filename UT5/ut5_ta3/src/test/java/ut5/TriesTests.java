package ut5;

import org.junit.*;

public class TriesTests {
    @Test
    public void testPredecir() {
        TArbolTrie trie=new TArbolTrie();
        trie.insertar("arbol");
        trie.insertar("arbolado");
        trie.insertar("arbolito");
        trie.insertar("arbolon");

        Assert.assertEquals(4, trie.predecir("arbol").size());
        
    }

    @Test
    public void testPredecirVacio(){
        TArbolTrie trie=new TArbolTrie();
        trie.insertar("arbol");
        trie.insertar("arbolado");
        trie.insertar("arbolito");
        trie.insertar("arbolon");

        Assert.assertEquals(4, trie.predecir("").size());
    }

    @Test
    public void testPredecirArbolVacio(){
        TArbolTrie trie=new TArbolTrie();
        
        Assert.assertEquals(null, trie.predecir("arbol"));
    }

    @Test
    public void testPredecirNoExiste(){
        TArbolTrie trie=new TArbolTrie();
        trie.insertar("arbol");
        trie.insertar("arbolado");
        trie.insertar("arbolito");
        trie.insertar("arbolon");

        Assert.assertEquals(0, trie.predecir("banana").size());
    }
}
