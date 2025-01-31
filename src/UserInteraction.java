import java.util.Scanner;

public class UserInteraction {
    private final Scanner input = new Scanner(System.in);

    // Méthode pour permettre à l'utilisateur de quitter le jeu.

    public boolean exitGame() {
        System.out.print("Voulez-vous quitter le jeu? (oui/non) : ");
        String response = input.next();
        // Comparer la réponse à "oui" et retourner le résultat
        return response.equals("oui");
    }

}
