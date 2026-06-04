import java.util.Arrays;

public class RotateBox {

    public static char[][] rotateTheBox(char[][] boxGrid) {

        int rows = boxGrid.length;
        int cols = boxGrid[0].length;

        // transpose 2d array to the right first (simulate falling) before rotating
        // start at the right of each array (bottom when rotated) to record empty indexes

        // for each array/row of boxGrid
        for(int i = 0; i < rows; i++) {

            int empty = -1; // fall index
            boolean haveEmpty = false; // if fall index exist

            // for each column of each row
            for(int j = cols - 1; j >= 0; j--) {

                if(boxGrid[i][j] == '.' && !haveEmpty) {
                    // if empty space and no previous empty, record index
                    empty = j;
                    haveEmpty = true;
                }
                else if(boxGrid[i][j] == '*') {
                    // if an obstacle, reset empty index
                    empty = -1;
                    haveEmpty = false;
                }
                else if(boxGrid[i][j] == '#' && haveEmpty) {
                    // if an object and empty index exist, move it
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--; // move empty index 1 index to the left
                }
            }
        }

        char[][] rotated = new char[cols][rows]; // rotated 2d array

        // default insert traversal of 2d array but take elements from boxGrid vertically

        // for each array/row of rotated
        for(int i = 0; i < cols; i++) {

            // for each column of each row
            for(int j = 0; j < rows; j++) {

                rotated[i][j] = boxGrid[rows - 1 - j][i];
                // (rows - 1) boxGrid rows (- j) starting from the highest
                // (i) column i of boxGrid is row i of rotated
            }
        }

        return rotated;
    }

    public static void main(String[] args) {

        System.out.println("1861. Rotating the Box");

        // example 1
        char[][] a1 = {{'#', '.', '.'}, {'#', '*', '.'}};
        System.out.println("\nOriginal:");
        printBox(a1);
        System.out.println("Rotated: ");
        printBox(rotateTheBox(a1));

        // example 2
        char[][] a2 = {{'#', '.', '*', '.'}, {'#', '#', '*', '.'}};
        System.out.println("\nOriginal:");
        printBox(a2);
        System.out.println("Rotated: ");
        printBox(rotateTheBox(a2));


    }

    public static void printBox(char[][] arrays) {

        for(char[] arr : arrays) System.out.println(Arrays.toString(arr));
    }
}
