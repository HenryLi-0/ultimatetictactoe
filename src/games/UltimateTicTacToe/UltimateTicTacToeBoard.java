package games.UltimateTicTacToe;

public class UltimateTicTacToeBoard {
    static String[][] board = new String[9][9];
    String theWinner = "";

    public UltimateTicTacToeBoard(){
        for (int b = 0; b < 9; b++){
            for (int i = 0; i < 9; i++){board[b][i] = " ";}
        }
    }

    public void set(int b, int i, String player){
        board[b][i] = player;
    }

    public String get(int b, int i){
        return board[b][i];
    }

    public String[][] getBoard(){
        return board;
    }

    public int filledSquares(int b){
        int counter = 0;
        for (int i = 0; i < 9; i++){
            if (board[b][i]!= " "){counter++;}
        }
        return counter;
    }

    public boolean gameStatus(){
        // String winner = "1155"; 
        // for (int i = 0; i < 3; i++){
        //     if (board[i*3+0]==board[i*3+1] && board[i*3+0]==board[i*3+2] && board[i*3+0]!=" "){winner = board[i*3+0];}
        //     if (board[i]==board[i+3] && board[i]==board[i+6] && board[i]!=" "){winner = board[i];}
        // }
        // if (board[0]==board[4] && board[0]==board[8] && board[0]!=" "){winner = board[0];}
        // if (board[2]==board[4] && board[2]==board[6] && board[2]!=" "){winner = board[2];}
        // if (winner!="1155"){
        //     System.out.println(winner + " wins!");
        //     theWinner=winner;
        //     return false;
        // }
        // boolean avaliable=false;
        // for (int i = 0; i < board.length; i++) {
        //     if (board[i]==" "){avaliable=true;}
        // }
        // if (!avaliable){
        //     System.out.println("both of you are equally bad");
        //     theWinner="_";
        //     return false;
        // }
        return true;
    }

    public void print(){
        System.out.println("    1   2   3   4   5   6   7   8   9  ");
            for (int i = 0; i < 9; i++){
                System.out.println("  +---+---+---+---+---+---+---+---+---+");
                System.out.println("ABCDEFGHI".charAt(i) + " | " 
                + board[((int) Math.floor(i/3))*3][(i%3)*3] + " | " + board[((int) Math.floor(i/3))*3][(i%3)*3+1] + " | " + board[((int) Math.floor(i/3))*3][(i%3)*3+2] 
                + " | " + board[((int) Math.floor(i/3))*3+1][(i%3)*3] + " | " + board[((int) Math.floor(i/3))*3+1][(i%3)*3+1] + " | " + board[((int) Math.floor(i/3))*3+1][(i%3)*3+2] 
                + " | " + board[((int) Math.floor(i/3))*3+2][(i%3)*3] + " | " + board[((int) Math.floor(i/3))*3+2][(i%3)*3+1] + " | " + board[((int) Math.floor(i/3))*3+2][(i%3)*3+2] + " |");
            }
            System.out.println("  +---+---+---+---+---+---+---+---+---+");
    }
}