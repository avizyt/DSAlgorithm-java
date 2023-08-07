package casestudy;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class UnionFind {
    private final int[] id;
    private int count;

    public int getCount() {
        return count;
    }

    public UnionFind(int N) {
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

    public int find(int p) {
        // component identifier for p (0 to N-1)
        return id[p];
    }

    public void union(int p, int q) {
        // add connection between q and q
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[q]) {
                id[i] = qID;
            }
            count--;
        }

    }

    public static void main(String[] args) {
        String filename = args[0];
        try {
        Scanner scanner = new Scanner(new File(filename));
        int N = scanner.nextInt();
        UnionFind uf = new UnionFind(N);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " components");

        scanner.close();
    } catch (FileNotFoundException e){
            e.printStackTrace();
        }
}}
