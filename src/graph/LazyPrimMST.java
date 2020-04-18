package graph;

import graph.undirectedgraph.SparseGraph;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ikaros
 * @date 2020/4/6 20:09
 */
public class LazyPrimMST {
    private SparseGraph G;
    private MinHeap pq;
    private boolean[] marked;
    private List<Edge> mst;
    private int mstWeight;
    
    
    
    @Test
    public void minHeapTest() {
        MinHeap minHeap = new MinHeap(100);
        
    }
    
    public LazyPrimMST(SparseGraph G) {
        pq = new MinHeap(G.V());
        marked = new boolean[G.V()];
        
        // LazyPrim
        visit(0);
    }
    
    private void visit(int v) {
        // 保证是蓝色的节点
        assert !marked[v];
        marked[v] = true;
    }
    
    public int result() {
        return mstWeight;
    }
    
    public List<Edge> getMst() {
        return mst;
    }
    
    class Edge {
        private int a;
        private int b;
        private int weight;
        
        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
        
        /**
         * 另外的顶点
         *
         * @param x
         *
         * @return
         */
        public int other(int x) {
            assert x == a || x == b;
            return a == x ? b : a;
        }
    }
    
    /**
     * 最小堆
     */
    class MinHeap {
        int count;
        int capacity;
        Edge[] data;
        
        MinHeap(int capacity) {
            this.capacity = capacity;
            data = new Edge[capacity];
            count = 0;
        }
        
        int size() {
            return count;
        }
        
        boolean isEmpty() {
            return count == 0;
        }
        
        void insert(Edge value) {
            assert count + 1 <= capacity;
            data[count] = value;
            shiftUp(count);
            count++;
        }
        
        private void shiftUp(int k) {
            Edge temp = data[k];
            while (k > 0 && data[(k - 1) / 2].weight > temp.weight) {
                data[k] = data[(k - 1) / 2];
                k = (k - 1) / 2;
            }
            data[k] = temp;
        }
        
        Edge extractMin() {
            assert count > 0;
            Edge result = data[0];
            swap(0, --count);
            shiftDown(0);
            return result;
        }
        
        private void shiftDown(int i) {
            Edge temp = data[i];
            while (i * 2 + 1 < count) {
                int j = i * 2 + 1;
                // 取左右树中最小数
                if (j + 1 < count && data[j + 1].weight < data[j].weight) {
                    j++;
                }
                if (temp.weight < data[j].weight) {
                    break;
                }
                data[i] = data[j];
                i = j;
            }
            data[i] = temp;
        }
        
        private void swap(int i, int i1) {
            Edge temp = data[i];
            data[i] = data[i1];
            data[i1] = temp;
        }
    }
}
