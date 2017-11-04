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
            case 5:
                return checkFor5(players);
            case 6:
                return checkFor6(players);
            case 7:
                return checkFor7(players);
            case 8:
                return checkFor8(players);
            case 9:
                return checkFor9(players);
            case 10:
                return checkFor10(players);
            default:
                System.out.println("Invalid input");
                break;
        }

        return false;
    }

    private boolean checkFor10(Players players) {
        return (cells[currentRow][0].players == players && cells[currentRow][1].players == players && cells[currentRow][2].players == players
                    && cells[currentRow][3].players == players && cells[currentRow][4].players == players && cells[currentRow][5].players == players
                    && cells[currentRow][6].players == players && cells[currentRow][7].players == players && cells[currentRow][8].players == players
                    && cells[currentRow][9].players == players
                || cells[0][currentCol].players == players && cells[1][currentCol].players == players && cells[2][currentCol].players == players
                    && cells[3][currentCol].players == players && cells[4][currentCol].players == players && cells[5][currentCol].players == players
                    && cells[6][currentCol].players == players && cells[7][currentCol].players == players && cells[8][currentCol].players == players
                    && cells[9][currentCol].players == players
                || currentRow == currentCol && cells[0][0].players == players && cells[1][1].players == players && cells[2][2].players == players
                    && cells[3][3].players == players && cells[4][4].players == players && cells[5][5].players == players
                    && cells[6][6].players == players && cells[7][7].players == players && cells[8][8].players == players
                    && cells[9][9].players == players
                || currentRow + currentCol == 9 && cells[0][9].players == players && cells[1][8].players == players && cells[2][7].players == players
                    && cells[3][6].players == players) && cells[4][5].players == players && cells[5][4].players == players && cells[6][3].players == players
                    && cells[7][2].players == players && cells[8][1].players == players && cells[9][0].players == players;
    }

    private boolean checkFor9(Players players) {
        return (cells[currentRow][0].players == players && cells[currentRow][1].players == players && cells[currentRow][2].players == players
                    && cells[currentRow][3].players == players && cells[currentRow][4].players == players && cells[currentRow][5].players == players
                    && cells[currentRow][6].players == players && cells[currentRow][7].players == players && cells[currentRow][8].players == players
                || cells[0][currentCol].players == players && cells[1][currentCol].players == players && cells[2][currentCol].players == players
                    && cells[3][currentCol].players == players && cells[4][currentCol].players == players && cells[5][currentCol].players == players
                    && cells[6][currentCol].players == players && cells[7][currentCol].players == players && cells[8][currentCol].players == players
                || currentRow == currentCol && cells[0][0].players == players && cells[1][1].players == players && cells[2][2].players == players
                    && cells[3][3].players == players && cells[4][4].players == players && cells[5][5].players == players
                    && cells[6][6].players == players && cells[7][7].players == players && cells[8][8].players == players
                || currentRow + currentCol == 8 && cells[0][8].players == players && cells[1][7].players == players && cells[2][6].players == players
                    && cells[3][5].players == players) && cells[4][4].players == players && cells[5][3].players == players && cells[6][2].players == players
                    && cells[7][1].players == players && cells[8][0].players == players;
    }

    private boolean checkFor8(Players players) {
        return (cells[currentRow][0].players == players && cells[currentRow][1].players == players && cells[currentRow][2].players == players
                    && cells[currentRow][3].players == players && cells[currentRow][4].players == players && cells[currentRow][5].players == players
                    && cells[currentRow][6].players == players && cells[currentRow][7].players == players
                || cells[0][currentCol].players == players && cells[1][currentCol].players == players && cells[2][currentCol].players == players
                    && cells[3][currentCol].players == players && cells[4][currentCol].players == players && cells[5][currentCol].players == players
                    && cells[6][currentCol].players == players && cells[7][currentCol].players == players
                || currentRow == currentCol && cells[0][0].players == players && cells[1][1].players == players && cells[2][2].players == players
                    && cells[3][3].players == players && cells[4][4].players == players && cells[5][5].players == players
                    && cells[6][6].players == players && cells[7][7].players == players
                || currentRow + currentCol == 7 && cells[0][7].players == players && cells[1][6].players == players && cells[2][5].players == players
                    && cells[3][4].players == players) && cells[4][3].players == players && cells[5][2].players == players && cells[6][1].players == players
                    && cells[7][0].players == players;
    }

    private boolean checkFor7(Players players) {
        return (cells[currentRow][0].players == players && cells[currentRow][1].players == players && cells[currentRow][2].players == players
                    && cells[currentRow][3].players == players && cells[currentRow][4].players == players && cells[currentRow][5].players == players
                    && cells[currentRow][6].players == players
                || cells[0][currentCol].players == players && cells[1][currentCol].players == players && cells[2][currentCol].players == players
                    && cells[3][currentCol].players == players && cells[4][currentCol].players == players && cells[5][currentCol].players == players
                    && cells[6][currentCol].players == players
                || currentRow == currentCol && cells[0][0].players == players && cells[1][1].players == players && cells[2][2].players == players
                    && cells[3][3].players == players && cells[4][4].players == players && cells[5][5].players == players
                    && cells[6][6].players == players
                || currentRow + currentCol == 6 && cells[0][6].players == players && cells[1][5].players == players && cells[2][4].players == players
                    && cells[3][3].players == players) && cells[4][2].players == players && cells[5][1].players == players && cells[6][0].players == players;
    }

    private boolean checkFor6(Players players) {
        return (cells[currentRow][0].players == players && cells[currentRow][1].players == players && cells[currentRow][2].players == players
                    && cells[currentRow][3].players == players && cells[currentRow][4].players == players && cells[currentRow][5].players == players
                || cells[0][currentCol].players == players && cells[1][currentCol].players == players && cells[2][currentCol].players == players
                    && cells[3][currentCol].players == players && cells[4][currentCol].players == players && cells[5][currentCol].players == players
                || currentRow == currentCol && cells[0][0].players == players && cells[1][1].players == players && cells[2][2].players == players
                    && cells[3][3].players == players && cells[4][4].players == players && cells[5][5].players == players
                || currentRow + currentCol == 5 && cells[0][5].players == players && cells[1][4].players == players && cells[2][3].players == players
                    && cells[3][2].players == players) && cells[4][1].players == players && cells[5][0].players == players;
    }

    private boolean checkFor5(Players players) {
        return (cells[currentRow][0].players == players && cells[currentRow][1].players == players && cells[currentRow][2].players == players
                        && cells[currentRow][3].players == players && cells[currentRow][4].players == players
                || cells[0][currentCol].players == players && cells[1][currentCol].players == players && cells[2][currentCol].players == players
                        && cells[3][currentCol].players == players && cells[4][currentCol].players == players
                || currentRow == currentCol && cells[0][0].players == players && cells[1][1].players == players && cells[2][2].players == players
                        && cells[3][3].players == players && cells[4][4].players == players
                || currentRow + currentCol == 4 && cells[0][4].players == players && cells[1][3].players == players && cells[2][2].players == players
                        && cells[3][1].players == players) && cells[4][0].players == players;
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
