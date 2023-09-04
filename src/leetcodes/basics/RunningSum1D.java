package leetcodes.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunningSum1D {
    public static void main(String[] args) {
        int[] arr = {3,1,2,10,1};
        System.out.println(runningSum(arr));

        int[] res = runningSumOptimized(arr);
        System.out.println(Arrays.toString(res));
    }

    private static List<Integer> runningSum(int[] arr) {
        int size = arr.length;
        int x = 0;
        List<Integer> sumArr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int temp = x + arr[i];
            sumArr.add(temp);
            x = temp;
        }
        return sumArr;
    }

    private static int[] runningSumOptimized(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
        }
        return arr;
    }

}
