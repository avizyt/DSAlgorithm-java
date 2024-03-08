package leetcodes.recursions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static void subsetSums(int[] arr, int idx, int sum, List<Integer> res){
        if (idx == arr.length){
            res.add(sum);
            return;
        }
        subsetSums(arr, idx+1, sum+arr[idx], res);
        subsetSums(arr, idx+1, sum, res);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3};
        List<Integer> subsetSums = new ArrayList<>();

        // Start recursion with initial index = 0 and sum = 0
        subsetSums(arr, 0, 0, subsetSums);

        // Sort the result if needed
//        Collections.sort(subsetSums);

        // Print the subset sums
        System.out.println("Subset sums: " + subsetSums);
    }
}
