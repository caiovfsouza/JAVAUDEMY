package application;

import java.util.Scanner;

public class ProgramMatriz {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int n = sc.nextInt();

        int[][] mat = new int[m][n];

        System.out.println();

        for (int i = 0; i < mat.length; i++) {
            System.out.print("Enter the numbers da " + (i + 1) + "ª line: ");
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println();
        System.out.print("Matriz "+ m + " x " + n + ":");
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }

        System.out.println();
        System.out.println();
        System.out.print("Enter a number belonging to the array: ");
        int x = sc.nextInt();
        System.out.println();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (x == mat[i][j]) {
                    System.out.println("Position: " + i + "," + j + ":");
                    if (j > 0) {
                        System.out.println("Left: " + mat[i][j - 1]);
                    }
                    if (i > 0) {
                        System.out.println("Up: " + mat[i - 1][j]);
                    }
                    if (j < mat[i].length - 1) {
                        System.out.println("Rigth: " + mat[i][j + 1]);
                    }
                    if (i < mat.length - 1) {
                        System.out.println("Down: " + mat[i + 1][j]);
                    }
                    System.out.println();
                }
            }
        }

        sc.close();

    }
}
