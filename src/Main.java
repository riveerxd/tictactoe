import java.util.Scanner;

public class Main {
    private static final int SIZE = 3;
    private static final char EMPTY = '-';
    private static char[][] board = new char[SIZE][SIZE];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        printBoard();

        // Hra
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;
        scanner.close();
    }


    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }





}



