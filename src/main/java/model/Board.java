package model;

import enums.Players;

public class Board {

    public static int ROWS;
    public static int COLS;

    public Cell[][] cells;
    public int currentRow, currentCol;
    public int size;

    public Board(int size) {
        this.size = size;
        ROWS = size;
        COLS = size;
        cells = new Cell[size][size];
        for (int i = 0; i < size; ++i) {
            for (int y = 0; y < size; ++y) {
                cells[i][y] = new Cell(i, y);
            }
        }
    }

    public void init(int size) {
        for (int i = 0; i < size; ++i) {
            for (int y = 0; y < size; ++y) {
                cells[i][y].clear();
            }
        }
    }

    public boolean isDraw() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (cells[row][col].players == Players.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWon(Players players) {


        return (cells[currentRow][0].players == players
                && cells[currentRow][1].players == players
                && cells[currentRow][2].players == players
                || cells[0][currentCol].players == players
                && cells[1][currentCol].players == players
                && cells[2][currentCol].players == players
                || currentRow == currentCol
                && cells[0][0].players == players
                && cells[1][1].players == players
                && cells[2][2].players == players
                || currentRow + currentCol == 2
                && cells[0][2].players == players
                && cells[1][1].players == players
                && cells[2][0].players == players);
    }

    public void paint(int size) {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                cells[row][col].paint();
                if (col < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (row < ROWS - 1) {
                for (int i = 0; i < (size * 4)-1; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
}
