package games.UltimateTicTacToe;

public class UltimateTicTacToeMoron {
    public static int[] calculateMove(String[][] board, int lastMiniGame){
        int[] choice = {((lastMiniGame == -1) ? (int) Math.round(Math.random()*8) : lastMiniGame), (int) Math.round(Math.random()*8)};
        while (board[choice[0]][choice[1]] != " "){
            choice[0] = ((lastMiniGame == -1) ? (int) Math.round(Math.random()*8) : lastMiniGame);
            choice[1] = (int) Math.round(Math.random()*8);
        }
        System.out.println(choice);
        return choice;
    }
}