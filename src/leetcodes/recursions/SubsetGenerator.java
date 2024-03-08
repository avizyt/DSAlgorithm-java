package leetcodes.recursions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetGenerator {
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(
            int[] nums,
            int start,
            List<Integer> subset,
            List<List<Integer>> res
    ) {
        res.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            backtrack(nums, i+1, subset, res);
            subset.remove(subset.size() -1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println("Subsets for arr: " + subsetsWithDup(arr));

        int[] arr1 = {0};
        System.out.println("Subsets for arr1: " + subsetsWithDup(arr1));
    }


}
