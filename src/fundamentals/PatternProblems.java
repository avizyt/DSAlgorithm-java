package fundamentals;

public class PatternProblems {
    public static void checkerBoard(int row, int col){
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col ; j++) {
                System.out.print("* ");
            }
            System.out.print(" ");
            System.out.println();
        }

    }
    public static void xPattern(int size){
        int mid = size/2;
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (i == j || j == size - i){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
//        checkerBoard(5,5);
        xPattern(6);
    }
}
