import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crée un scanner pour lire les entrées de l'utilisateur
        Scanner input = new Scanner(System.in);
        // Demande à l'utilisateur de choisir le type de joueur pour Player 1
        System.out.println("Choisissez le type de joueur pour Player 1 (1 pour humain, 2 pour artificiel): ");
        int choice1 = input.nextInt();
        // Initialise Player 1 en fonction du choix de l'utilisateur
        // Si l'utilisateur entre 1, Player 1 sera un joueur humain
        // Si l'utilisateur entre 2, Player 1 sera un joueur artificiel
        Player player1;
        if (choice1 == 1) {
            player1 = new HumanPlayer("| X ");
        } else {
            player1 = new ArtificialPlayer("| X ");
        }
        // Demande à l'utilisateur de choisir le type de joueur pour Player 2
        System.out.println("Choisissez le type de joueur pour Player 2 (1 pour humain, 2 pour artificiel): ");
        int choice2 = input.nextInt();
        // Initialise Player 2 en fonction du choix de l'utilisateur
        // Si l'utilisateur entre 1, Player 2 sera un joueur humain
        // Si l'utilisateur entre 2, Player 2 sera un joueur artificiel
        Player player2;
        if (choice2 == 1) {
            player2 = new HumanPlayer("| O ");
        } else {
            player2 = new ArtificialPlayer("| O ");
        }
        TicTacToe ticTacToe = new TicTacToe(player1, player2);
        ticTacToe.display();
        ticTacToe.play();

    }

}