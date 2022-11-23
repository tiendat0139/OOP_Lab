package hust.soict.dsai.lab01;

public class AddMatrices {
    public static void printMatrix (int rows, int cols, int [][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int [][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] matrix2 = {{2 ,4, 6}, {1, 3, 5}, {3, 6, 9}};
        int [][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Matrix 1: ");
        printMatrix(rows, cols, matrix1);
        System.out.println("Matrix 2: ");
        printMatrix(rows, cols, matrix2);
        System.out.println("Result : ");
        printMatrix(rows, cols, result);

    }
}
