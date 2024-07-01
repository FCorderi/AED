package TemplateGrafos.src.main.java.uy.edu.ucu.aed;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; // lista de vertices del grafo.-

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     *         contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    public TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            tempbool = (vertOrigen != null) && (vertDestino != null);
            if (tempbool) {
                // getLasAristas().add(arista);
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }

        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * @return the vertices
     */
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
       this.desvisitarVertices();
        Collection<TVertice> visitados=new LinkedList<TVertice>();
        
        if(this.existeVertice(vertice.getEtiqueta()))
        {
            TVertice vert=this.buscarVertice(vertice.getEtiqueta());
            vert.bpf(visitados);
        }
        return visitados;
    }

    @Override
    public boolean tieneCiclo(TCamino camino) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Collection<TVertice> bpf() {
        Collection<TVertice> listaBpf = new LinkedList<TVertice>();
        this.desvisitarVertices();
        
        if (vertices.isEmpty()) {
            System.out.println("El grafo está vacio");
        } else {
            for (TVertice vertV : vertices.values()) {
                if (!vertV.getVisitado()) {
                    vertV.bpf(listaBpf);
                }
            }
        }
        return listaBpf;
    }

    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        Collection<TVertice> visitados=new LinkedList<TVertice>();
        
        if(this.existeVertice(etiquetaOrigen))
        {
            TVertice vertice=this.buscarVertice(etiquetaOrigen);
            vertice.bpf(visitados);
        }
        return visitados;
    }

    @Override
    public Comparable centroDelGrafo() {
        Iterator<TVertice> it = vertices.values().iterator();
        Comparable[] excentricidades = new Comparable[vertices.size()];
        Comparable centro = Double.MAX_VALUE;
        Comparable etiqueta_centro = null;
        int i = 0;
        while(it.hasNext()){
            Comparable a = excentricidades[i];
            Comparable etiqueta_vertice = it.next().getEtiqueta();
            
             a = this.obtenerExcentricidad(etiqueta_vertice);
            if(a.compareTo(centro) == -1){
                centro = a;
                etiqueta_centro = etiqueta_vertice;
            }
        }
        return etiqueta_centro+" (" + centro.toString().trim()+")";
    }

    @Override
    public Double[][] floyd() {
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(vertices);
        for (int k = 0; k < matriz.length; k++) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if(i!=j && i!=k && k!=j){
                        if (matriz[i][k] + matriz[k][j] < matriz[i][j]) {
                            matriz[i][j] = matriz[i][k] + matriz[k][j];
                            //matrizRetroceso[i][j]=Double.parseDouble(Integer.toString(k));
                        }
                    }
                }
            }
        } 


        
        return matriz;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] matriz = this.floyd();
        Set<Comparable> etiquetasVertices = this.vertices.keySet();
        Comparable[] array = new Comparable[matriz.length];
        array = etiquetasVertices.toArray(array);
        int columna = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == etiquetaVertice){
                columna = i;
                break;
            }
        }
        Double ex = 0.0;
        for (int i =0; i<matriz.length; i++){
            if(matriz[i][columna]>ex && matriz[i][columna]<Double.MAX_VALUE && matriz[i][columna]>0.0){
                ex = matriz[i][columna];
            }
        }
        if (ex == 0.0){
            ex = Double.MAX_VALUE;
        }
        return ex;
    }

    @Override
    public boolean[][] warshall() {
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(getVertices());
        boolean[][] war = new boolean[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                war[i][j] = false;

                if (i != j && matriz[i][j] != Double.MAX_VALUE) {
                    war[i][j] = true;
                }
            }
        }
        for (int k = 0; k < war.length; k++) {
            for (int i = 0; i < war.length; i++) {
                for (int j = 0; j < war.length; j++) {
                    if ((i != k) && (k != j) && (i != j)) {
                        if (!war[i][j]) {
                            war[i][j] = war[i][k] && war[k][j];
                        }
                    }
                }
            }
        }
        return war;
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        
        TVertice v = buscarVertice(etiquetaOrigen);
        TVertice u = buscarVertice(etiquetaDestino);
        if ((v != null)&&(u != null)) {
            TCaminos todosLosCaminos = new TCaminos();
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;

    }

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
       desvisitarVertices();
        boolean res = false;
        
        for (TVertice vertV : vertices.values()) {
            if (!vertV.getVisitado()) {
                LinkedList camino = new LinkedList();
                camino.add(vertV.getEtiqueta());
                res = vertV.tieneCiclo(camino);
                return true;
            }
        }
        return res;
    }

    @Override
    public boolean tieneCiclo() {
        desvisitarVertices();
        boolean res = false;
        
        for (TVertice vertV : vertices.values()) {
            if (!vertV.getVisitado()) {
                LinkedList camino = new LinkedList();
                camino.add(vertV.getEtiqueta());
                res = vertV.tieneCiclo(camino);
                if(res){
                    return true;
                }
            }
        }
        return res;
    }

    @Override
    public Collection<TVertice> bea() {
       if (this.getVertices().isEmpty()) {
            return null;
        } else {
            this.desvisitarVertices();
            for (TVertice vertV : this.getVertices().values()) {
                if (!vertV.getVisitado()) {
                   Collection<TVertice> verts = new LinkedList<TVertice>();
                   vertV.bea(verts);
                   return verts;
                }
            }
        }
        return null;
    }
    


}
