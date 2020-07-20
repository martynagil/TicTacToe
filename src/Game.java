import java.util.Scanner;

public class Game {

    private static final char PLAYER_O = 'O';
    private static final char PLAYER_X = 'X';
    private static final char EMPTY = '.';

    private char[][] board = new char[3][3];
    private char currentPlayer = PLAYER_O;
    private boolean finish = false;

    private Scanner scanner = new Scanner(System.in);

    public Game() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void run() {
        while (!finish) {
            chosePlace();
            checkWinner();
            printBoard();
            changePlayer();
        }
        changePlayer();
        System.out.println("The winner is " + currentPlayer);
    }

    private void checkWinner() {
        if(checkWinnerColumn() || checkWinnerRow() || checkWinnerDiagonal()){
            finish = true;
        }
    }

    private boolean checkWinnerRow() {
        if (board[0][0] != EMPTY && board[0][0] == board[1][0] && board[0][0] == board[2][0]){
            return true;
        }
        if (board[0][1] != EMPTY && board[0][1] == board[1][1] && board[0][1] == board[2][1]){
            return true;
        }
        if (board[0][2] != EMPTY && board[0][2] == board[1][2] && board[0][2] == board[2][2]){
            return true;
        }
        return false;
    }

    private boolean checkWinnerColumn() {
        if (board[0][0] != EMPTY && board[0][0] == board[0][1] && board[0][0] == board[0][2]){
            return true;
        }
        if (board[1][0] != EMPTY && board[1][0] == board[1][1] && board[1][0] == board[1][2]){
            return true;
        }
        if (board[2][0] != EMPTY && board[2][0] == board[2][1] && board[2][0] == board[2][2]){
            return true;
        }
        return false;
    }

    private boolean checkWinnerDiagonal() {
        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            return true;
        }
        if (board[2][0] != EMPTY && board[2][0] == board[1][1] && board[2][0] == board[0][2]){
            return true;
        }
        return false;
    }

    private void enterCharToBoard(int column, int row) {
        board[column][row] = currentPlayer;
    }

    private void changePlayer() {
        if (currentPlayer == PLAYER_O) {
            currentPlayer = PLAYER_X;
        } else {
            currentPlayer = PLAYER_O;
        }
    }

    private void chosePlace() {
        boolean checkingIfPlaceIsFree = false;
        while (!checkingIfPlaceIsFree) {
            System.out.print("Give number of column: ");
            int column = scanner.nextInt();
            System.out.print("Give number of row: ");
            int row = scanner.nextInt();
            if (board[column][row] == EMPTY) {
                enterCharToBoard(column, row);
                checkingIfPlaceIsFree = true;
            } else {
                System.out.println("Place is taken");
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[j][i]);
            }
            System.out.println();
        }
    }

}

