package leetcodes.basics;

public class NumberSteps2Zero {
    public static void main(String[] args) {
        int num = 123;
        System.out.println(calculateSteps(num));
    }

    private static int calculateSteps(int num) {
        int steps = 0;
        int value = num;
        while (value > 0){
            if (value % 2 == 0){
                value = value >> 1;
            } else {
                value = value -1;
            }
            steps += 1;
        }
        return steps;
    }

    private static int calSteps(int num){

    }
}
