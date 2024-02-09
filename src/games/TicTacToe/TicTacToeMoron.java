package games.TicTacToe;

public class TicTacToeMoron {
    public static int calculateMove(String[] board){
        int choice = (int) Math.round(Math.random()*8);
        while (board[choice]!=" "){
           choice = (int) Math.round(Math.random()*8);
        }
        return choice;
    }
}