package casestudy;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
    private final int[] id;
    private int count;

    public int getCount() {
        return count;
    }

    public UnionFind(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        // return true if p and q are the same component
        return find(p) == find(q);
    }

    public int count() {
        // number of component.
        return count;
    }
    public int find (int p) {
        // component identifier for p (0 to N-1)
        return id[p];
    }

    public void union(int p, int q) {
        // add connection between q and q
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[q]){
                id[i] = qID;
            }
            count--;
        }

    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UnionFind uf = new UnionFind(N);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q );
        }
        StdOut.println(uf.count() + " components");
    }
}
