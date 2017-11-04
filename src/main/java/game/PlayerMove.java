package game;

import enums.Players;
import model.Board;
import model.Movement;

import java.util.Scanner;


public class PlayerMove {

    private static Scanner in = new Scanner(System.in);

    public static void playerMove(Players players, Board board) {
        boolean validInput = false;
        int row = -1;
        int col = -1;

        do {
            if (players == Players.X) {
                System.out.printf("Player 'X', enter your move ([1-%d],[1-%d]): ", board.size, board.size);
            } else if (players == Players.O) {
                System.out.printf("Player 'O', enter your move ([1-%d],[1-%d]): ", board.size, board.size);
            } else {
                Movement movement = AIMove.compRandomMove(board.size);
                row = movement.getRow();
                col = movement.getColumn();
            }

            if (!(players == Players.COMP)) {
                try {
                    String line = in.nextLine();
                    String[] array = line.split(",");
                    row = Integer.parseInt(array[0]) - 1;
                    col = Integer.parseInt(array[1]) - 1;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
                    && board.cells[row][col].players == Players.EMPTY) {
                board.cells[row][col].players = players;
                board.currentRow = row;
                board.currentCol = col;
                validInput = true;
            } else {
                if (!(players == Players.COMP)) {
                    System.out.println("Move (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again...");
                }
            }
        } while (!validInput);
    }

}
