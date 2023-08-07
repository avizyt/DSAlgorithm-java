package graph.problems;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private final List<Integer>[] adj;
    @SuppressWarnings("unchecked")
    public Graph(int V){
        this.V = V;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }
    public int V(){
        return V;
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
