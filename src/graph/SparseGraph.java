package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏图
 * 邻接表
 *
 * @author Ikaros
 * @date 2020/4/6 16:48
 */
public class SparseGraph {
    private int n;
    private int m;
    private boolean directed;
    private List<Integer>[] g;
    
    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
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
        g[v].add(w);
        // 自环
        if (v != w && !directed) {
            g[w].add(v);
        }
        m++;
    }
    
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v].contains(w);
    }
}
