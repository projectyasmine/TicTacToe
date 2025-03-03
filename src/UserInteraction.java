import java.util.Scanner;

public class UserInteraction {
    private final Scanner input = new Scanner(System.in);

    // Méthode pour récupérer le choix de la pièce à jouer
    public int[] getMoveFromPlayer(Cell[][] board, int boardSize) {
        int row, col;
        while (true) {
            System.out.print("Entrez les coordonnées (0, 1 ou 2) : ");
            row = input.nextInt();
            col = input.nextInt();
            if (row < 0 || row >= boardSize) {
                System.out.println("Ligne invalide, recommencer");
            } else if (col < 0 || col >= boardSize) {
                System.out.println("Colonne invalide, recommencer");
            } else if (!board[row][col].getRepresentation().equals("|   ")) {
                System.out.println("Case déjà occupée, recommencer");
            } else {
                break;
            }
        }
        return new int[]{row, col};
    }



    // Méthode pour permettre à l'utilisateur de quitter le jeu.

    public boolean exitGame() {
        System.out.print("Voulez-vous quitter le jeu? (oui/non) : ");
        String response = input.next();
        // Comparer la réponse à "oui" et retourner le résultat
        return response.equals("oui");
    }

}
