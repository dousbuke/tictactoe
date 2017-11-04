import enums.Players;
import enums.Status;
import game.GameStatus;
import game.PlayerMove;
import game.SetUp;
import model.Board;

public class TicTacToe {

    public Board gameBoard;
    public Status gameStatus;
    public Players currentPlayer;

    public TicTacToe() {
        gameBoard = SetUp.gameBoardSetUp();
        currentPlayer = SetUp.gameSideSetUp();
        gameStatus = SetUp.initGame();

        do {
            PlayerMove.playerMove(currentPlayer, gameBoard);
            gameBoard.paint(gameBoard.size);
            gameStatus = GameStatus.gameStatusCheck(currentPlayer, gameBoard);

            if (gameStatus == Status.X_WIN) {
                System.out.println("'X' won!");
            } else if (gameStatus == Status.O_WIN) {
                System.out.println("'O' won!");
            } else if (gameStatus == Status.COMP_WIN) {
                System.out.println("'Comp' won!");
            } else if (gameStatus == Status.DRAW) {
                System.out.println("It's Draw!");
            }

            if (currentPlayer == Players.X) {
                currentPlayer = Players.O;
            } else if (currentPlayer == Players.O) {
                currentPlayer = Players.COMP;
                System.out.println("Computer's turn.");
            } else {
                currentPlayer = Players.X;
            }

        } while (gameStatus == Status.PLAYING);
    }


    public static void main(String[] args) {
        new TicTacToe();
    }
}
