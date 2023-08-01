package sortings;

import edu.princeton.cs.algs4.StdOut;

import static fundamentals.LargeNumberStringArray.randomStringGenerator;

public class ShellSort {
    public static void sort(Comparable[] a){
        int size = a.length;
        int h = 1;
        while (h < size/3){
            h = 3*h +1;
        }
        while (h >= 1){
            for (int i = 0; i < size; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]) ; j -=h) {
                    exch(a, j, j-h);
                }
                h = h/3;
            }
        }
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
//        String[] a = {"23", "12", "42", "56", "32"};
//        String[] a = {"c", "a", "e", "l", "f"};

        int arrSize = 1000;
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
