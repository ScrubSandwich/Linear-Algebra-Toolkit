import java.util.Scanner;

public class LinearAlgebraToolkit {
  
  public static Scanner reader = new Scanner(System.in);

  public static void printPrompt() {
    System.out.println();
    System.out.println();
    
    System.out.println("=====Linear Algebra Toolkit=====");
    System.out.println("1. Determinant of nxn matrix");
    System.out.println("99. Exit");
  }

  public static void printMatrix(int[][] matrix) {
    System.out.println();
    System.out.println(matrix.length + "x" + matrix.length + " matix A:");

    for (int i = 0 ; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] getMatrixInput() {
    System.out.println("Enter the value of n:");
    int n = reader.nextInt();

    int[][] m = new int[n][n];

    for (int i = 0 ; i < n; i++) {
      System.out.println("Enter each element of row " + (i + 1) + " by hitting enter in between each number:");
      for (int j = 0; j < n; j++) {
        m[i][j] = reader.nextInt();
      }
    }

    return m;
  }

  // public static int determinant() {

  // }

  public static void main(String[] args) {
    while (true) {
      printPrompt();

      int input = reader.nextInt();

      if (input == 1) {
        //determinant(matrix);

        int[][] matrix = getMatrixInput();
        printMatrix(matrix);
      } else {
        System.out.println("Goodbye");
        System.exit(0);
      }
    }    
  }
}