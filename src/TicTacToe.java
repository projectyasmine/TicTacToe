public class TicTacToe {
    public final int boardSize = 3;
    public Cell[][] board;
    public Player player1;
    public Player player2;
    private Player actualPlayer;

    public TicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        board = new Cell[boardSize][boardSize];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Cell();
            }
        }
//        playerX = new Player("| X ");
//        playerO = new Player("| O ");

    }

    public void display() {
        for (int i = 0; i < boardSize; i++) {
            System.out.println("-".repeat(13));
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(13));
    }


    public void setOwner(int row, int col, Player player) {
        board[row][col].setOwner(player);
    }

    public void play() {
        // Joueur actuel initialisé à playerX
         actualPlayer = player1;
        while (!isOver()) {
            // Affiche le plateau de jeu
            display();
            // Affiche le tour du joueur actuel
            System.out.println("Tour de " + actualPlayer.getRepresentation().replace("|",""));
            // Obtient le mouvement du joueur actuel
            int[] move = actualPlayer.getMoveFromPlayer(board, boardSize);
            // Définit le propriétaire de la case choisie par le joueur actuel
            setOwner(move[0], move[1], actualPlayer);
            if (isOver()) {
                break;
            };
            // Vérifie que le joueur actuel est égale à playerX
            if (actualPlayer == player1) {
                // Si le joueur actuel est playerX, le joueur suivant sera playerO
                actualPlayer = player2;
            } else {
                // Sinon, le joueur suivant sera playerX
                actualPlayer = player1;
            }
        }
        // Affiche le plateau de jeu final
        display();
        System.out.println("Jeu terminé!");
    }

    public boolean isOver() {
        boolean isOver = false;

        /*
        1. Créer une fonction isFull retourne true si toutes les cases du tableau sont occupés
        isFull prend en paramètre le board
        2. Créer une fonction hasWinner qui retourne true si nb case sont alignés dans le board
        hasWinner prends en paramètre le nb de case pour gagner, le tableau et le symbole à tester
        3. Retourne true si au moins une des conditions est vraie
         */

        isOver = isFull() || hasWinner( 3);
        return isOver;
    }

    public boolean isFull() {
        boolean isFull = true;
//        this.board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                isFull = isFull && board[i][j].isOccupied();
            }
        }

        return isFull;
    }

    public boolean hasWinner(int nb) {
        boolean isWinner = false;
        int cpt=0;

        // Vérifier les lignes
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].getRepresentation().equals(actualPlayer.getRepresentation())) {
                    cpt++;
                } else {
                    cpt=0;
                }
                if (cpt == nb) {
                    return true;
                }
            }
        }

        // Vérifier les colonnes
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j].getRepresentation().equals(actualPlayer.getRepresentation())) {
                    cpt++;
                } else {
                    cpt=0;
                }
                if (cpt == nb) {
                    return true;
                }
            }
        }

        // Vérifier les diagonales

        for (int i = 0; i < board.length; i++) {
            if (board[i][i].getRepresentation().equals(actualPlayer.getRepresentation())) {
                cpt++;
            } else {
                cpt = 0;
            }
            if (cpt == nb) {
                return true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[board.length-i-1][i].getRepresentation().equals(actualPlayer.getRepresentation())) {
                cpt++;
            } else {
                cpt = 0;
            }
            if (cpt == nb) {
                return true;
            }
        }

        /*

         */
        return isWinner;
    }

}

//        // Vérifier les lignes
//        if ((board[0][0].getRepresentation().equals(board[0][1].getRepresentation()) && board[0][0].getRepresentation().equals(board[0][2].getRepresentation()) && !board[0][0].getRepresentation().equals("|   ")) ||
//                (board[1][0].getRepresentation().equals(board[1][1].getRepresentation()) && board[1][0].getRepresentation().equals(board[1][2].getRepresentation()) && !board[1][0].getRepresentation().equals("|   ")) ||
//                (board[2][0].getRepresentation().equals(board[2][1].getRepresentation()) && board[2][0].getRepresentation().equals(board[2][2].getRepresentation()) && !board[2][0].getRepresentation().equals("|   "))) {
//            return true;
//        }
//
//        // Vérifier les colonnes
//        if ((board[0][0].getRepresentation().equals(board[1][0].getRepresentation()) && board[0][0].getRepresentation().equals(board[2][0].getRepresentation()) && !board[0][0].getRepresentation().equals("|   ")) ||
//                (board[0][1].getRepresentation().equals(board[1][1].getRepresentation()) && board[0][1].getRepresentation().equals(board[2][1].getRepresentation()) && !board[0][1].getRepresentation().equals("|   ")) ||
//                (board[0][2].getRepresentation().equals(board[1][2].getRepresentation()) && board[0][2].getRepresentation().equals(board[2][2].getRepresentation()) && !board[0][2].getRepresentation().equals("|   "))) {
//            return true;
//        }
//
//        // Vérifier les diagonales
//        if ((board[0][0].getRepresentation().equals(board[1][1].getRepresentation()) && board[0][0].getRepresentation().equals(board[2][2].getRepresentation()) && !board[0][0].getRepresentation().equals("|   ")) ||
//                (board[0][2].getRepresentation().equals(board[1][1].getRepresentation()) && board[0][2].getRepresentation().equals(board[2][0].getRepresentation()) && !board[0][2].getRepresentation().equals("|   "))) {
//            return true;
//        }
//
//        // Vérifier si le plateau est rempli
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (board[i][j].getRepresentation().equals("|   ")) {
//                    return false;
//                }
//            }
//        }
//
//        return true;