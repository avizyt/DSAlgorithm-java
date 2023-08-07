package fundamentals;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;
public class TestingClients {

    public static double avgMarks(List<Integer> marks){
        int total = 0;
        int cnt = 0;
        for (int mark: marks){
            total += mark;
            cnt += 1;
        }
        return (double) total/cnt;
    }
    public static double sdOfMarks(List<Integer> marks){
        double mean = avgMarks(marks);
        double total = 0;
        int cnt = 0;
        List<Double> diffs = new ArrayList<>();
        for (int mark: marks){
            double diff = mark-mean;
            diffs.add(diff);
            cnt += 1;
        }
        for (double diff: diffs){
            total += diff;
        }

        return Math.sqrt(total/cnt);

    }
    public static void main(String[] args) {
        System.out.println("Statistics Of Class");

        List<Integer> marks = new ArrayList<>();
        In in = new In(args[0]);

        while (!in.isEmpty()){
            (marks).add(in.readInt());
        }
        double mean = avgMarks(marks);
        double std = sdOfMarks(marks);
        System.out.println("Mean of marks: "+ mean);
        System.out.println("SD of marks: "+ std);
    }
}
