package graph.problems;

import java.util.Stack;

public class DepthFirstPaths {
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }
    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w: G.adj(v)){
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        int V = 6;
        Graph G = new Graph(V);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);
        G.addEdge(2, 4);
        G.addEdge(4, 5);

        int sourceVertex = 0;

        DepthFirstPaths dfsPaths = new DepthFirstPaths(G, sourceVertex);


        System.out.println("path from: " + sourceVertex);
        for (int v = 0; v < G.V(); v++) {
            if (dfsPaths.hasPathTo(v)){
                System.out.print(v +": " );
                Iterable<Integer> path = dfsPaths.pathTo(v);
                for (int vertex: path){
                    System.out.print(vertex + " ");
                }
                System.out.println();
            } else {
                System.out.println("No path from " + sourceVertex+ " to "+v);
            }
        }
    }
}
