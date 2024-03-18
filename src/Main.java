import java.util.Scanner;

public class Main {
    private static final int SIZE = 3;
    private static final char EMPTY = '-';
    private static char[][] board = new char[SIZE][SIZE];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        printBoard();
        initializeBoard();

        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;
        while (!gameEnded) {
            System.out.println("Hráč " + currentPlayer + ", zadej pozici (řádek sloupec): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                if (isWinningMove(row, col)) {
                    gameEnded = true;
                    System.out.println("Hráč " + currentPlayer + " vyhrál!");
                } else if (isBoardFull()) {
                    gameEnded = true;
                    System.out.println("Remíza!");
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    printBoard();
                }
            } else {
                System.out.println("Neplatný tah, zkuste znovu.");
            }
        }
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
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY;
    }

    private static boolean isWinningMove(int row, int col) {
        return (board[row][0] == currentPlayer
                && board[row][1] == currentPlayer
                && board[row][2] == currentPlayer
                || board[0][col] == currentPlayer
                && board[1][col] == currentPlayer
                && board[2][col] == currentPlayer
                || row == col
                && board[0][0] == currentPlayer
                && board[1][1] == currentPlayer
                && board[2][2] == currentPlayer
                || row + col == SIZE - 1
                && board[0][2] == currentPlayer
                && board[1][1] == currentPlayer
                && board[2][0] == currentPlayer);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}










