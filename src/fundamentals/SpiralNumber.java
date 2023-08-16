package fundamentals;

/**
 * 1	2	3	4	5
 * 16	17	18	19	6
 * 15	24	25	20	7
 * 14	23	22	21	8
 * 13	12	11	10	9
 */
public class SpiralNumber {
    public static void spiralPrint(int size){
        int[][] spiral = new int[size][size];
        int val = 1;

        int rowStart = 0, rowEnd = size - 1;
        int colStart = 0, colEnd = size - 1;

        while (val <= size * size){
            // travers right
            for (int i = colStart; i <= colEnd; i++) {
                spiral[rowStart][i] = val++;
            }
            rowStart++;

            // Travers down
            for (int i = rowStart; i >= rowEnd; i--) {
                spiral[i][colEnd] = val++;
            }
            colEnd--;
            // Traverse left
            for (int i = colEnd; i >= colStart; i--) {
                spiral[rowEnd][i] = val++;
            }
            rowEnd--;

            // Travers up
            for (int i = rowEnd; i >= rowStart; i--) {
                spiral[i][colStart] = val++;
            }
            colStart++;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(spiral[i][j]+ "\t");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        int size = 5;
        // Print the spiral pattern
        spiralPrint(size);
    }

}
