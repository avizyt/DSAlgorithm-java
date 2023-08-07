package graph;

import edu.princeton.cs.algs4.Graph;

public class Search {
    private boolean[] marked;
    private int count;
    private int source;

    public Search(Graph G, int s){
        marked = new boolean[G.V()];
        source = s;
        count = 0;
        dfs(G,s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for (int w: G.adj(v)){
            if (!marked[w]){
                dfs(G, w);
            }
        }
    }
    public boolean marked(int v){
        return marked[v];
    }
    public int count(){
        return count;
    }
}
