package graph.undirectedgraph;

/**
 * 图的接口
 */
public interface Graph {
    
    int V();
    
    int E();
    
    void addEdge(int v, int w);
    
    boolean hasEdge(int v, int w);
    
    void show();
    
    Iterable<Integer> adj(int v);
}