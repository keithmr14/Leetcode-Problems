import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {

        int loops = matrix[0].length / 2; // define how many loops are there
        int lastCol = matrix[0].length - 1; // inner array size index
        int lastRow = matrix.length - 1; // outer array size index
        int inners = lastCol - 1; // number of indexes to rotate

        for(int i = 0; i <= loops; i++) { // for each loop > 4x4

            for(int j = 0; j <= inners; j++) { // rotate loop

                // four side's indexes needs to be rotated together
                int a = matrix[i][j + i];
                int b = matrix[j + i][lastCol - i];
                int c = matrix[lastRow - i][lastCol - j - i];
                int d = matrix[lastRow - i - j][i];

                matrix[i][j + i] = d;
                matrix[j + i][lastCol - i] = a;
                matrix[lastRow - i][lastCol - j - i] = b;
                matrix[lastRow - i - j][i] = c;
            }

            inners -= 2; // reduce rotatable size by 2
        }

        for (int[] arrays : matrix) System.out.println(Arrays.toString(arrays));
    }

    public static void main(String[] args) {

        System.out.println("48. Rotate Image\n");

        // example 1
        int[][] a1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Original:");
        for(int[] arrays : a1) System.out.println(Arrays.toString(arrays));
        System.out.println("Rotated:");
        rotate(a1);

        // example 2
        int[][] a2 = {{5, 1, 9, 11 }, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        System.out.println("\nOriginal:");
        for (int[] arrays : a2) System.out.println(Arrays.toString(arrays));
        System.out.println("Rotated:");
        rotate(a2);
    }
}
