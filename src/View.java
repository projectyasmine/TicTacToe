public class View {
    public void display(Cell[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println("-".repeat(13));
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(13));
    }

}
