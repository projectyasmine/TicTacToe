import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] getMoveFromPlayer(Cell[][] board, int boardSize) {
        Scanner input = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.print(" (0, 1, ou 2): ");
            row = input.nextInt();
            col = input.nextInt();
            if (row < 0 || row >= boardSize) {
                System.out.println("Ligne invalide, recommencer");
            } else if (col < 0 || col >= boardSize) {
                System.out.println("Colonne invalide, recommencer");
            } else if (!board[row][col].getRepresentation().equals("|   ")) {
                System.out.println("Case déjà occupé, recommencer");
            } else {
                break;
            }
        }
        return new int[]{row, col};
    }




}
