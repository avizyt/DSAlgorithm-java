package graph;

import edu.princeton.cs.algs4.Graph;

public class DepthFirstSearch {
    private final boolean[] marked;
    private int count;
    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    private void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for (int w: G.adj(v)){
            if (!marked[w]){
                dfs(G,w);
            }
        }
    }
    public boolean getMarked(int w){
        return marked[w];
    }
    public int getCount(){
        return count;
    }
}
