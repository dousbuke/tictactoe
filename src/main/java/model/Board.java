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

    public void paint(int size) {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                cells[row][col].paint();
                if (col < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (row < ROWS - 1) {
                for (int i = 0; i < (size * 4) - 1; i++) {
                    System.out.print("-");
                }
                System.out.println();
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

    public boolean checkForWin(Players players, int size) {
        switch (size) {
            case 3:
                return checkFor3(players);
            case 4:
                return checkFor4(players);
            default:
                System.out.println("Invalid input");
                break;
        }

        return false;
    }

    private boolean checkFor4(Players players) {
        return (cells[currentRow][0].players == players && cells[currentRow][1].players == players && cells[currentRow][2].players == players && cells[currentRow][3].players == players
                || cells[0][currentCol].players == players && cells[1][currentCol].players == players && cells[2][currentCol].players == players && cells[3][currentCol].players == players
                || currentRow == currentCol && cells[0][0].players == players && cells[1][1].players == players && cells[2][2].players == players && cells[3][3].players == players
                || currentRow + currentCol == 3 && cells[0][3].players == players && cells[1][2].players == players && cells[2][1].players == players && cells[3][0].players == players);
    }

    private boolean checkFor3(Players players) {
        return (cells[currentRow][0].players == players && cells[currentRow][1].players == players && cells[currentRow][2].players == players
                || cells[0][currentCol].players == players && cells[1][currentCol].players == players && cells[2][currentCol].players == players
                || currentRow == currentCol && cells[0][0].players == players && cells[1][1].players == players && cells[2][2].players == players
                || currentRow + currentCol == 2 && cells[0][2].players == players && cells[1][1].players == players && cells[2][0].players == players);
    }

}
