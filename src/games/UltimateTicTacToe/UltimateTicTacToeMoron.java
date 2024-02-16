package games.UltimateTicTacToe;

public class UltimateTicTacToeMoron {
    public static int[] calculateMove(String[][] board){
        int[] choice = {(int) Math.round(Math.random()*8), (int) Math.round(Math.random()*8)};
        return choice;
    }
}