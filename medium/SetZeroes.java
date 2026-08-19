package medium;

import java.util.*;
import static utils.ArrayUtils.*;

public class SetZeroes {

    public static void setZeroes(int[][] matrix) {

        if(matrix.length == 0) throw new IllegalArgumentException("matrix mustn't be empty");
        if(matrix[0].length == 0) throw new IllegalArgumentException(
                "matrix row at index 0 mustn't be empty");

        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> setRowZero = new HashSet<>();
        Set<Integer> setColZero = new HashSet<>();

        for (int row = 0; row < m; row++) {

            if(matrix[row].length != n)
                throw new IllegalArgumentException("matrix must have uniform row lengths");

            for (int col = 0; col < n; col++) {

                if (matrix[row][col] == 0) {

                    setRowZero.add(row);
                    setColZero.add(col);
                }
            }
        }
        for(int row : setRowZero) {
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
        }
        for(int col : setColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
        // remove this to reduce runtime in leetCode or add it to show result
        print2dPrimMultiLine(matrix);
    }

    public static void main(String[] args) {

        System.out.println("73. Set Matrix Zeroes");

        // example 1
        int[][] m1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("\nMatrix:");
        print2dPrimMultiLine(m1);
        System.out.println("\nSet Zeroes:");
        setZeroes(m1);

        // example 2
        int[][] m2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println("\nMatrix:");
        print2dPrimMultiLine(m2);
        System.out.println("\nSet Zeroes:");
        setZeroes(m2);
    }
}
