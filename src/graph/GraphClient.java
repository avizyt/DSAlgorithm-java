package graph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class GraphClient {
    // maximum degree
    public static int maxDegree(Graph G){
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if (G.degree(v) > max){
                max = G.degree(v);
            }
        }
        return max;
    }

    // average degree
    public static int avgDegree(Graph G){
        return 2 * G.E() / G.V();
    }

    // number of self loops
    public static int numberOfSelfLoops(Graph G){
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w: G.adj(v)){
                if (v == w) count++;
            }
        }
        return count/2;
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);

        StdOut.println("vertex of maximum degree = " + maxDegree(G));
        StdOut.println("average degree           = " + avgDegree(G));
        StdOut.println("number of self loops     = " + numberOfSelfLoops(G));
    }
}

