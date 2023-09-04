package leetcodes.basics;

public class RichestBankAccount {
    public static void main(String[] args) {
        int[][] arr = {
                {7,1,3},
                {2,8,7},
                {1,9,5}
        };
//        System.out.println(highestWealthUtil(arr[0]));
//        System.out.println(highestWealthUtil(arr[1]));
//        System.out.println(highestWealthUtil(arr[2]));
        System.out.println(highestWealth(arr));
        System.out.println(richestMan(arr));

    }

    private static int highestWealth(int[][] arr) {
        int m = arr.length;
        int richest = 0;
        for (int i = 0; i < m; i++) {
            int sum = highestWealthUtil(arr[i]);
            if (richest < sum){
                richest = sum;
            }
        }
        return richest;

    }
    private static int highestWealthUtil(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static int richestMan(int[][] nums){
        int richest = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums[i].length; j++) {

                temp += nums[i][j];

            }
            if (richest < temp){
                richest = temp;
            }
        }
        return richest;
    }
}
