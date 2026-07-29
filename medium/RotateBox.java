package medium;

import static utils.ArrayUtils.*;

public class RotateBox {

    public static char[][] rotateTheBox(char[][] boxGrid) {

        if(boxGrid.length == 0) throw new IllegalArgumentException("the matrix is null");
        if(boxGrid[0].length == 0) throw new IllegalArgumentException("the top row has no characters");

        int rows = boxGrid.length;
        int cols = boxGrid[0].length;

        // move falling characters to the right first before rotating
        for(int i = 0; i < rows; i++) {

            if(boxGrid[i].length != cols)
                throw new IllegalArgumentException("the matrix have different row lengths");

            int fallAt = -1;

            for(int j = cols - 1; j >= 0; j--) {

                char c = boxGrid[i][j];

                if(c == '.') {
                    if(fallAt == -1) fallAt = j;
                }
                else if(c == '*') {
                    fallAt = -1;
                }
                else if(c == '#') {
                    if(fallAt != -1) {
                        boxGrid[i][j] = '.';
                        boxGrid[i][fallAt] = '#';
                        fallAt--;
                    }
                }
                else throw new IllegalArgumentException(
                        "invalid character '" + c + "' found at index (" + i + ", " + j + ")");
            }
        }

        char[][] rotated = new char[cols][rows];

        for(int i = 0; i < cols; i++)

            for(int j = 0; j < rows; j++)

                rotated[i][j] = boxGrid[rows - 1 - j][i];

        return rotated;
    }

    public static void main(String[] args) {

        System.out.println("1861. Rotating the Box");

        // example 1
        char[][] a1 = {{'#', '.', '.'}, {'#', '*', '.'}};
        System.out.println("\nOriginal:");
        print2dPrimMultiLine(a1);
        System.out.println("Rotated: ");
        print2dPrimMultiLine(rotateTheBox(a1));

        // example 2
        char[][] a2 = {{'#', '.', '*', '.'}, {'#', '#', '*', '.'}};
        System.out.println("\nOriginal:");
        print2dPrimMultiLine(a2);
        System.out.println("Rotated: ");
        print2dPrimMultiLine(rotateTheBox(a2));

        // example 3
        char[][] a3 = {{'#', '.', '.'}};
        System.out.println("\nOriginal:");
        print2dPrimMultiLine(a3);
        System.out.println("Rotated: ");
        print2dPrimMultiLine(rotateTheBox(a3));
    }
}
