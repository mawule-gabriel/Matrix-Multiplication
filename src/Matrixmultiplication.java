import java.util.Scanner;

public class Matrixmultiplication {

    int[][] matrixA, matrixB, matrixC;
    int matrixA_row, matrixA_col, matrixB_row, matrixB_col;
    Scanner input;


    public Matrixmultiplication(){
        input = new Scanner(System.in);

        System.out.print("Enter the number of rows and columns for Matrix A: ");
        matrixA_row = input.nextInt();
        matrixA_col = input.nextInt();

        System.out.print("Enter the number of rows and columns for Matrix B: ");
        matrixB_row = input.nextInt();
        matrixB_col = input.nextInt();

        if(matrixA_col != matrixB_row){
            System.out.println("This operation won't be possible because the row of Matrix A should be equal to the column of Matrix B");
        }
        else{
            matrixOperation();
        }

    }

    private void matrixOperation() {
        matrixA = new int[matrixA_row][matrixA_col];
        matrixB = new int[matrixB_row][matrixB_col];
        matrixC = new int[matrixA_row][matrixB_col];

        System.out.println("Enter " + matrixA_row * matrixA_col + " digits for matrixA" );
        for(int i=0; i<matrixA_row; i++){
            for(int j=0; j<matrixA_col; j++){
                while(!input.hasNextInt()){
                    System.out.println("Invalid input. Please enter an integer: ");
                    input.next();
                }
                matrixA[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter " + matrixB_row * matrixB_col + " digits for matrixB" );
        for(int i=0; i<matrixB_row; i++){
            for(int j=0; j<matrixB_col; j++){
                while(!input.hasNextInt()){
                    System.out.println("Invalid input. Please enter an integer: ");
                }
                matrixB[i][j] = input.nextInt();
            }
        }

        for(int i=0; i<matrixA.length; i++){
            for(int j=0; j<matrixB[0].length; j++){
                matrixC[i][j] = 0;

                for(int k=0; k<matrixA[0].length; k++){
                    matrixC[i][j] = matrixC[i][j] + matrixA[i][j] * matrixB[k][j];
                }
            }
        }

        for(int[] a : matrixC){
            for(int elements : a){
                System.out.print(elements + " ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {

        Matrixmultiplication matrixmultiplication = new Matrixmultiplication();


    }

}