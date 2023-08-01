package stack.problems;

import java.util.Scanner;
import java.util.Stack;

/**
 * Write a program in java that takes from standard input an expression without left parentheses and
 * prints the equivalent infix expression with the parentheses inserted. For example, given the
 * input: 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * output:  ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */

public class InfixExpressionWithParentheses {
    public static String insertParentheses(String input) {
        Stack<String> operandstack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for (char c: input.toCharArray()){
            if (c == ' ' || c == '\t'){

            }else if (Character.isDigit(c)){
                operandstack.push(Character.toString(c));
            }else if (c ==')'){
                String operand2 = operandstack.pop();
                String operator = operatorStack.pop();
                String operand1 = operandstack.pop();
                operandstack.push("( " + operand1 + " " + operator + " " + operand2 + " )");
            } else {
                operatorStack.push(Character.toString(c));
            }
        }
        return operatorStack.pop();

    }


    // Test main
    public static void main (String[]args){
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the expression without left parentheses: ");
//        String input = scanner.nextLine();
//        scanner.close();
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String infixExpression = insertParentheses(input);
        System.out.println("Output: " + infixExpression);
    }
}
