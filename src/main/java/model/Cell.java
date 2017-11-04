package model;

import enums.Players;

public class Cell {

    public Players players;
    public int row, col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clear();
    }

    public void clear() {
        players = Players.EMPTY;
    }

    public void paint() {
        switch (players) {
            case X:  System.out.print(" X "); break;
            case O: System.out.print(" O "); break;
            case COMP: System.out.print(" C "); break;
            case EMPTY:  System.out.print("   "); break;
        }
    }

}
