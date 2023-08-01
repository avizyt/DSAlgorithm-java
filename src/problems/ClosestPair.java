package problems;

import java.util.Arrays;

public class ClosestPair {
    public static void main(String[] args) {
        double[] arr = {1.2, 2.4, 3.7, 4.1, 5.0, 6.8, 7.3, 8.9};
        Pair closestPair = findClosestPair(arr);

        System.out.println("Closest pair: (" + closestPair.first + ", " + closestPair.second + ")");
        System.out.println("Difference: " + Math.abs(closestPair.first - closestPair.second));

    }

    public static Pair findClosestPair(double[] arr) {
        Arrays.sort(arr);
        return findClosestPairUtil(arr, 0, arr.length - 1);
    }

    public static Pair findClosestPairUtil(double[] arr, int left, int right) {
        if (left >= right) {
            return new Pair(Double.MAX_VALUE, Double.MAX_VALUE);
        }
        int mid = left + (right - left) / 2;

        Pair leftPair = findClosestPairUtil(arr, left, mid);
        Pair rightPair = findClosestPairUtil(arr, mid+1, right);
        Pair mergePair = mergePairs(leftPair, rightPair, arr[mid], arr[mid+1]);

        return getMinDistancePair(leftPair, rightPair, mergePair);
    }

    public static Pair mergePairs(Pair leftPair, Pair rightPair, double midValue1, double midValue2) {
        double minDiff = Math.min(Math.abs(leftPair.first - leftPair.second), Math.abs(rightPair.first - rightPair.second));
        return new Pair(midValue1, midValue2, minDiff);
    }

    public static Pair getMinDistancePair(Pair pair1, Pair pair2, Pair pair3) {
        if (pair1.distance <= pair2.distance && pair1.distance <= pair3.distance) {
            return pair1;
        } else if (pair2.distance <= pair1.distance && pair2.distance <= pair3.distance) {
            return pair2;
        } else {
            return pair3;
        }
    }
}

    class Pair {
        double first;
        double second;
        double distance;

        public Pair(double first, double second){
            this.first = first;
            this.second = second;
            this.distance = Math.abs(first - second);
        }
        public Pair(double first, double second, double distance){
            this.first = first;
            this.second = second;
            this.distance = distance;
        }


    }

