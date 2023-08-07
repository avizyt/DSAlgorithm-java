package graph;

public class DigraphClient {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();

        for (int i = 1; i <= 5 ; i++) {
            graph.addNode(i);
        }

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        // Test the methods
        System.out.println("Nodes in the graph: " + graph.getNode());
        System.out.println("Edges from node 1: " + graph.getEdges(1));
        System.out.println("Graph has node 3: " + graph.hasNode(3));
        System.out.println("Graph has edge (2, 4): " + graph.hasEdge(2, 4));
        System.out.println("Is the graph cyclic? " + graph.isCycle());

        System.out.println("Topological Sort: " + graph.topologicalSort());
        System.out.println("BFS: " + graph.BFS(2));
    }
}
