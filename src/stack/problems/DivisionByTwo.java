package stack.problems;

import javax.swing.*;
import java.util.Stack;

public class DivisionByTwo {
    public static void main(String[] args) {
        int num = 242;
//        System.out.println(decimal2Binary(num));
        decimal2BinarySt(num);
    }

    public static String decimal2Binary(int num) {
        if (num == 0){
            return "";
        }

        StringBuilder binary = new StringBuilder();
        while (num > 0){
            int remainder = num % 2;
            binary.insert(0, remainder);
            num /= 2;
        }
        return binary.toString();
    }

    public static void decimal2BinarySt(int num){
        int INITIAL_NUM = num;
        int cnt = 1;
        Stack<Integer> binStk = new Stack<>();

        while (num > 0){
            System.out.println();
            System.out.println("STEP: "+ cnt);
            int rem = num % 2;
            System.out.println("Remainder: " + rem);
            binStk.push(rem);
            System.out.println("Now stack is -> "+ binStk);
            num /= 2;
            System.out.println("Now Number is: "+ num);
            cnt += 1;
        }
        System.out.println("---------------------------------------------");
        System.out.print("Binary Representation of Number "+ INITIAL_NUM+ " is -> ");
        while (!binStk.isEmpty()){
            int item = binStk.pop();
            System.out.print(item);
        }

    }
}
