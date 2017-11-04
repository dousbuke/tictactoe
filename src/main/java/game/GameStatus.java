package game;

import enums.Players;
import enums.Status;
import model.Board;

public class GameStatus {

    public static Status gameStatusCheck(Players players, Board board) {
        if (board.checkForWin(players, board.size)) {
            if (players == Players.X) {
                return Status.X_WIN;
            } else if (players == Players.O) {
                return Status.O_WIN;
            } else {
                return Status.COMP_WIN;
            }
        } else if (board.isDraw()) {
            return Status.DRAW;
        }

        return Status.PLAYING;
    }
}
