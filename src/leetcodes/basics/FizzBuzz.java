package leetcodes.basics;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizzBuzzChecker(n));
    }

    private static List<String> fizzBuzzChecker(int n) {
        List<String> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean divBy3 = i % 3 == 0;
            boolean divBy5 = i % 5 == 0;
            if (divBy3 && divBy5){
                arr.add("FizzBuzz");
            } else if (divBy3) {
                arr.add("Fizz");
            }else if (divBy5){
                arr.add("Buzz");
            }else {
                arr.add(String.valueOf(i));
            }
        }
        return arr;
    }
}
