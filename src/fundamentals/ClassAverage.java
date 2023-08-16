package fundamentals;

import java.util.Scanner;

public class ClassAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        int cnt = 0;
        System.out.print("Enter grade or -1 to quit: ");
        int grade = input.nextInt();
        while (grade != -1){
            total += grade;
            cnt++;

            System.out.print("Enter grade or -1 to quit: ");
            grade = input.nextInt();
        }

        if (cnt != 0){
            double avg = (double) total/cnt;

            System.out.printf("%nTotal of the %d grades entered is %d%n",
                    cnt, total);
            System.out.printf("Class average is %.2f%n", avg);

        } else {
            System.out.println("No grade");
        }
    }
}
