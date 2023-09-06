package leetcodes.arraysAndString;

public class MaxSubArray1 {
    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        int[] arr2 = {5};
        int k = 4;
        int k2 = 1;
        System.out.println(findMaxAvg(arr, k));
//        System.out.println(findMaxAvg(arr2, k2));
    }

    private static double findMaxAvg(int[] nums, int k) {
        int n = nums.length;
        if (n < k){
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxAvg = (double) sum /k;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i-k];
            maxAvg = Math.max(maxAvg, (double) sum/k);
        }
        return maxAvg;
    }
}
