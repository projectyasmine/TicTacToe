public abstract class Player {
    public String representation;

    public Player(String representation) {
        this.representation = representation;
    }

    // Méthode pour obtenir le symbole du joueur
    public String getRepresentation() {
        return representation;
    }

    public abstract int[] getMoveFromPlayer(Cell[][] board, int boardSize);

}
