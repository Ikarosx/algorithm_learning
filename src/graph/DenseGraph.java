package graph;

/**
 * 稠密图
 * 邻接矩阵
 *
 * @author Ikaros
 * @date 2020/4/6 16:38
 */
public class DenseGraph {
    private int n;
    private int m;
    private boolean directed;
    private boolean[][] g;
    
    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
    }
    
    public int V() {
        return n;
    }
    
    public int E() {
        return m;
    }
    
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }
    
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }
}
