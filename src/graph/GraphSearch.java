package graph;

import java.util.LinkedList;

public class GraphSearch {
    private final int V;
    private final LinkedList<Integer>[] adjList;

    GraphSearch(int v){
        V = v;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adjList[v].add(w);
    }

    void DFS(int startVertex){
        boolean[] visited = new boolean[V];
        DFSUtil(startVertex, visited);
    }

    private void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.println(v + " ");

        for (int neighbour: adjList[v]){
            if (!visited[neighbour])
                DFSUtil(neighbour, visited);
        }
    }


    public static void main(String[] args) {
        GraphSearch g = new GraphSearch(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2,5);
        g.addEdge(3,6);
        g.addEdge(6,7);

        System.out.println("Depth-First Traversal (starting from vertex 0):");
        g.DFS(2);
    }
}
