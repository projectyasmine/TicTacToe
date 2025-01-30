import java.util.Random;

public class ArtificialPlayer extends Player {
    public ArtificialPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] getMoveFromPlayer(Cell[][] board, int boardSize) {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(board.length);
            col = rand.nextInt(board[0].length);
        } while (board[row][col].isOccupied());
        return new int[]{row, col};
    }




}
