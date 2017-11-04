package game;

import enums.Players;
import enums.Status;
import model.Board;

import java.util.Random;
import java.util.Scanner;

public class SetUp {

    private static Scanner in = new Scanner(System.in);
    private static Random generator = new Random();

    public static Board gameBoardSetUp() {
        int size;
        Board board;

        do {
            System.out.print("Enter the size of board between 3-10 :");
            size = in.nextInt();
            if (size < 3 || size > 10) {
                System.out.println("You entered out range size");
            }
        } while (size < 3 || size > 10);

        System.out.println("Board size set to: " + size);
        board = new Board(size);

        board.init(size);

        return board;
    }

    public static Players gameSideSetUp() {
        Players currentPlayer;

        int startNumber = generator.nextInt(3);

        if (startNumber == 0) {
            currentPlayer = Players.X;
            System.out.println("Player X Starts");
        } else if (startNumber == 1){
            currentPlayer = Players.O;
            System.out.println("Player O Starts");
        } else {
            currentPlayer = Players.COMP;
            System.out.println("Computer Starts");
        }

        return currentPlayer;
    }

    public static Status initGame() {
        return Status.PLAYING;
    }
}
