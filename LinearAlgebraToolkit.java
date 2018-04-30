import java.util.Scanner;

public class LinearAlgebraToolkit {
  
  public static Scanner reader = new Scanner(System.in);

  public static void printPrompt() {
    System.out.println();
    System.out.println();
    
    System.out.println("=====Linear Algebra Toolkit=====");
    System.out.println("1. Determinant of nxn matrix");
    System.out.println("2. Is nxn matrix symmetric");
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

  public static boolean isSquare(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix.length != matrix[i].length) { return false; }
      }
    }

    return true;
  }

  public static boolean isSymmetric(int[][] matrix){
    if (!isSquare(matrix)) { return false; }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] != matrix[j][i]) { return false; }
      }
    }

    return true;
  }

  public static boolean isDiagonal(int[][] matrix){
    if (!isSquare(matrix)) { return false; }

    for (int i = 0; i < matrix.length; i++){
      for (int j = 0; j < matrix[i].length; j++){
        if (i != j){
          if (matrix[i][j] != 0){
            return false;
          }
        }
      }
    }

    return true;
  }

  public static int determinant(int[][] m) {
    int n = m.length;

    if (n == 1) {
      return (m[0][0]);
    }

    if (n == 2) {
      return ((m[0][0] * m[1][1]) - (m[0][1] * m[1][0]));
    }

    int sum = 0;

    for (int j = 0; j < n; j++) {
      int[][] m2 = new int[n - 1][n - 1];

      // Populate the smaller matrix with the correct values from the original
      for (int k = 0; k < m2.length; k++) {

        int h = 0;
        for (int p = 0; p < n; p++) {

          // If we are at the jth column, don't add anyhthing to the matrix
          if (p != j) {
            m2[k][h++] = m[k + 1][p];
          }
        }
      }

      sum += ( (getSign(j) * m[0][j]) * determinant(m2) );
    }

    return sum;
  }

  // Return +1 if i is even
  // Return -1 if i is odd
  public static int getSign(int i) {
    if (i % 2 == 0) {
      return 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    while (true) {
      printPrompt();

      int input = reader.nextInt();

      if (input == 99) {
        System.out.println("Goodbye");
        System.exit(0);
      }

      int[][] matrix = getMatrixInput();
      
      if (input == 1) {
        System.out.println();
        System.out.println("Determinant of the " + matrix.length + "x" + matrix.length + " matrix:");
        System.out.println(determinant(matrix));
      } else if (input == 2) {
        System.out.println();
        System.out.print("The " + matrix.length + "x" + matrix.length + " matrix is ");

        if (isSymmetric(matrix)) { System.out.println("symmetric"); }
        else { System.out.println("not symmetric"); }
      }
    }    
  }
}