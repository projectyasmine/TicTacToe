public class Cell {
    public Player owner;

    // Méthode pour obtenir la représentation de la cellule
    public String getRepresentation () {
        if (owner == null) {
            return "|   ";
        } else {
            return owner.getRepresentation();
        }
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public boolean isOccupied() {
        if (owner == null) {
            return false;
        }
        return true;
    }
}
