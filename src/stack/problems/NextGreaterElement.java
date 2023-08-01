package stack.problems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();

        int[] nums = {1,2,4,3,5};
        int[] result = solution.nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }
}
