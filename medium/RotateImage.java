package medium;

import static utils.ArrayUtils.*;

public class RotateImage {
    public static void rotate(int[][] matrix) {

        if(matrix.length == 0) throw new IllegalArgumentException("matrix mustn't be empty");
        if(matrix[0].length == 0) throw new IllegalArgumentException(
                "matrix row at index 0 mustn't be empty");

        int length = matrix[0].length;

        for(int[] row : matrix) {

            if(row.length != length)
                throw new IllegalArgumentException("matrix must have uniform row lengths");
        }

        int loops = matrix[0].length / 2;
        int lastCol = matrix[0].length - 1;
        int lastRow = matrix.length - 1;
        int inners = lastCol - 1;

        for(int i = 0; i <= loops; i++) {
            for(int j = 0; j <= inners; j++) {

                int a = matrix[i][j + i]; // top side
                int b = matrix[j + i][lastCol - i]; // right side
                int c = matrix[lastRow - i][lastCol - j - i]; // bottom side
                int d = matrix[lastRow - i - j][i]; // left side

                matrix[i][j + i] = d; // left into top
                matrix[j + i][lastCol - i] = a; // top into right
                matrix[lastRow - i][lastCol - j - i] = b; // right into bottom
                matrix[lastRow - i - j][i] = c; // bottom into left
            }

            inners -= 2; // reduce rotatable indexes by 2
        }
        // remove this to reduce runtime in leetCode or add it to show result
        print2dPrimMultiLine(matrix);
    }

    public static void main(String[] args) {

        System.out.println("48. Rotate Image");

        // example 1
        int[][] a1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("\nOriginal:");
        print2dPrimMultiLine(a1);
        System.out.println("Rotated:");
        rotate(a1);

        // example 2
        int[][] a2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        System.out.println("\nOriginal:");
        print2dPrimMultiLine(a2);
        System.out.println("Rotated:");
        rotate(a2);
    }
}
