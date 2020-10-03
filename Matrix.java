import java.util.Scanner;
public class Matrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //input row
        int m = input.nextInt(); //input column
        int t = input.nextInt(); //input how many times of instructions
        int[][] mat = new int[n][m]; //make array
        for(int i = 0; i < n; i++){ //input matrix
            for (int j = 0; j < m; j++){
                mat[i][j] = input.nextInt();
            }
        }
        for(int h = 0; h < t; h++) { //instructions
            int inst = input.nextInt();
            if (inst == 0){ //rotate instruction
                mat = rotate(n, m, mat);
                int temp = n;
                n=m;
                m=temp;

            }
            else if (inst == 1){ //flip instruction
                flip(n, m, mat);
            }
        }
        cetak(n, m, mat); //print out the matrix
    }
    private static int[][] rotate(int r,int c,int[][] matx) { //rotate instruction
        int[][] mat = new int [c][r]; //new array
        for(int i = 0; i < r; i++){
            for(int k = 0; k < c; k++){
                mat[k][i] = matx[r-i-1][k]; //filling new array with rotated matrix
            }
        }
        return mat; //return the rotated matrix
    }
    private static void flip(int n, int m, int[][] mat) { //flip instruction
        for (int i = 0; i < m; i++) //flipping matrix
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int temp = mat[j][i];
                mat[j][i] = mat[k][i];
                mat[k][i] = temp;
            }
    }
    private static void cetak(int n, int m, int[][] mat){ //print out instruction
        System.out.println(n+" "+m); //print row x column
        for(int i = 0; i < n; i++){ //print the matrix
            for (int j = 0; j < m; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
