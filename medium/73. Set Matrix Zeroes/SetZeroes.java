import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetZeroes {

    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        // rows and column to be set as zeroes
        Set<Integer> setRowZero = new HashSet<>();
        Set<Integer> setColZero = new HashSet<>();

        // traverse the matrix to find each zeroes
        for(int row = 0; row < m; row++)
            for(int col = 0; col < n; col++)
                if(matrix[row][col] == 0) {
                    // add the rows and columns to be set to zeroes
                    setRowZero.add(row);
                    setColZero.add(col);
                }
        
        // set each said rows to zeroes
        for(int row : setRowZero)
            for(int i = 0; i < n; i++)
                matrix[row][i] = 0;
        
        // set each said columns to zeroes
        for(int col : setColZero)
            for(int i = 0; i < m; i++)
                matrix[i][col] = 0;

        print2dInt(matrix);
    }

    public static void main(String[] args) {

        System.out.println("73. Set Matrix Zeroes");

        // example 1
        int[][] m1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("\nMatrix:");
        print2dInt(m1);
        System.out.println("After:");
        setZeroes(m1);

        // example 2
        int[][] m2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println("\nMatrix:");
        print2dInt(m2);
        System.out.println("After:");
        setZeroes(m2);
    }

    public static void print2dInt(int[][] arrays) {

        for(int[] arr : arrays)
            System.out.println(Arrays.toString(arr));
    }
}
