import java.util.Scanner;

public class Matrixmultiplication {

    int[][] matrixA, matrixB, matrixC;
    int matrixA_row, matrixA_col, matrixB_row, matrixB_col;
    Scanner input;


    public Matrixmultiplication(){
        input = new Scanner(System.in);

        // Getting dimensions for Matrix A
        System.out.print("Enter the number of rows and columns for Matrix A (rows columns): ");
        while(!input.hasNextInt()){
            System.out.println("Please enter a valid value for rows and columns (1-100): ");
            input.next();
        }
        matrixA_row = input.nextInt();
        matrixA_col = input.nextInt();

        // Getting dimensions for Matrix B
        System.out.print("Enter the number of rows and columns for Matrix B (rows columns): ");
        while(!input.hasNextInt()){
            System.out.println("Please enter a valid value for rows and columns (1-100): ");
            input.next();
        }
        matrixB_row = input.nextInt();
        matrixB_col = input.nextInt();

        // Checking matrix multiplication condition
        if(matrixA_col != matrixB_row){
            System.out.println("Matrix multiplication is not possible because the number of columns in Matrix A should be equal to the number of rows in Matrix B.");
        }
        else{
            matrixOperation();
        }
    }

    private void matrixOperation() {
        matrixA = new int[matrixA_row][matrixA_col];
        matrixB = new int[matrixB_row][matrixB_col];
        matrixC = new int[matrixA_row][matrixB_col];

        // Input for Matrix A
        System.out.println("Enter " + matrixA_row * matrixA_col + " elements for Matrix A:");
        for(int i = 0; i < matrixA_row; i++){
            for(int j = 0; j < matrixA_col; j++){
                // Prompting user with index for each element in matrix A
                System.out.print("Enter element [" + i + "][" + j + "] for Matrix A: ");
                while(!input.hasNextInt()){
                    System.out.println("Invalid input. Please enter an integer: ");
                    input.next(); // discard invalid input
                }
                matrixA[i][j] = input.nextInt();
            }
        }

        // Input for Matrix B
        System.out.println("Enter " + matrixB_row * matrixB_col + " elements for Matrix B:");
        for(int i = 0; i < matrixB_row; i++){
            for(int j = 0; j < matrixB_col; j++){
                // Prompting user with index for each element in matrix B
                System.out.print("Enter element [" + i + "][" + j + "] for Matrix B: ");
                while(!input.hasNextInt()){
                    System.out.println("Invalid input. Please enter an integer: ");
                    input.next(); // discard invalid input
                }
                matrixB[i][j] = input.nextInt();
            }
        }

        // Matrix multiplication logic
        for(int i = 0; i < matrixA.length; i++){
            for(int j = 0; j < matrixB[0].length; j++){
                matrixC[i][j] = 0;
                for(int k = 0; k < matrixA[0].length; k++){
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        // Output the resulting matrix C
        System.out.println("The results for matrix C is: ");
        for(int[] row : matrixC){
            for(int element : row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        new Matrixmultiplication();
    }
}
