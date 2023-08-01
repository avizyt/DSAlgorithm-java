package sortings;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static fundamentals.LargeNumberStringArray.randomStringGenerator;

public class QuickSort {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int low, int high){
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }

    private static int partition(Comparable[] a, int low, int high ){
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true){
            while (less(a[++i], v)){
                if (i == high) break;
            }
            while (less(v, a[--j])){
                if (j == low) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, high);
        return j;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arrSize = 10000;
        int strLength = 10;
        // Start
        long startTime = System.nanoTime();
        String[] a = randomStringGenerator(arrSize, strLength);
        sort(a);
        assert isSorted(a);
        show(a);
        long endTime = System.nanoTime();
        double exeTime = (endTime - startTime)/1000000;
        StdOut.println("Time taken for sorting "+arrSize+ " item: " +exeTime);
    }
}
