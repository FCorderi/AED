package com.example.GrafoNoDirigido;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido, IGrafoKevinBacon {
    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
        
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        if(!esConexo())
            return null;
        LinkedList<Comparable> verticesAux = new LinkedList(getVertices().keySet());
        LinkedList<TArista> aristasAAM = new LinkedList<>();
        LinkedList<Comparable> verticesAAM = new LinkedList<>();
        verticesAAM.add(verticesAux.removeFirst());
        while (!verticesAux.isEmpty()){
            TArista aristaAux = lasAristas.buscarMin(verticesAAM, verticesAux);
            aristasAAM.add(aristaAux);
            verticesAAM.add(aristaAux.getEtiquetaDestino());
            verticesAux.remove(aristaAux.getEtiquetaDestino());
        }
        return new TGrafoNoDirigido(new LinkedList(getVertices().values()), aristasAAM);
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        if (!esConexo()){
            return null;
        }
        TGrafoNoDirigido grafoAAM = new TGrafoNoDirigido(new LinkedList(getVertices().values()), new LinkedList<TArista>());
        TAristas aristasAux = (TAristas) getLasAristas().clone();

        while(!grafoAAM.esConexo()){
            TArista aritasMinAux = aristasAux.buscarMin(getVertices().keySet(), getVertices().keySet());
        }

        return grafoAAM;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        desvisitarVertices();
        Collection<TVertice> resultado = new LinkedList<TVertice>();
        TVertice verticeOrigen = getVertices().get(etiquetaOrigen);

        if (verticeOrigen != null) {
            verticeOrigen.bea(resultado);

            for (TVertice vertice : getVertices().values()) {
                if (!vertice.getVisitado()) {
                    this.bea(vertice);
                }
            }
        }
        return resultado;
    }

    @Override
    public Collection<TVertice> bea() {
        desvisitarVertices();
        Collection<TVertice> resultado = new LinkedList<TVertice>();
        for (TVertice vertice : getVertices().values()) {
            if (!vertice.getVisitado()) {
                this.bea(vertice);
            }
        }
        return resultado;
    }

    public Collection<TVertice> bea(TVertice verticeOrigen) {
        desvisitarVertices();
        Collection<TVertice> resultado = new LinkedList<TVertice>();

        if (verticeOrigen.getEtiqueta() != null) {
            verticeOrigen.bea(resultado);

            for (TVertice vertice : getVertices().values()) {
                if (!vertice.getVisitado()) {
                    vertice.bea(resultado);
                }
            }
        }
        return resultado;
    }

    @Override
    public boolean esConexo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esConexo'");
    }

    @Override
    public boolean conectados(TVertice origen, TVertice destino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'conectados'");
    }

    @Override
    public int numBacon(Comparable actor) {
        desvisitarVertices();
        TVertice actorVertice = buscarVertice(actor);
        TVertice bacon = buscarVertice("Kevin_Bacon");
        if(bacon == null){
            //exception, retornar un valor de error
        }
        if(actor.equals(bacon.getEtiqueta())){
            return 0;
        }
        if(actorVertice.getBacon() < 0){
            bacon.numBacon(actor);
        }
        return actorVertice.getBacon();
    }
}
