package games.TicTacToe;

public class TicTacToeBoard {
    static String[] board = new String[9];
    static String theWinner = "";

    public TicTacToeBoard(){
        for (int i = 0; i < 9; i++){board[i] = " ";}
    }

    public void set(int i, String player){
        board[i] = player;
    }

    public String get(int i){
        return board[i];
    }

    public String[] getBoard(){
        return board;
    }

    public int filledSquares(){
        int counter = 0;
        for (int i = 0; i < 9; i++){
            if (board[i]!= " "){counter++;}
        }
        return counter;
    }

    public boolean gameStatus(){
        String winner = "1155"; 
        for (int i = 0; i < 3; i++){
            if (board[i*3+0]==board[i*3+1] && board[i*3+0]==board[i*3+2] && board[i*3+0]!=" "){winner = board[i*3+0];}
            if (board[i]==board[i+3] && board[i]==board[i+6] && board[i]!=" "){winner = board[i];}
        }
        if (board[0]==board[4] && board[0]==board[8] && board[0]!=" "){winner = board[0];}
        if (board[2]==board[4] && board[2]==board[6] && board[2]!=" "){winner = board[2];}
        if (winner!="1155"){
            System.out.println(winner + " wins!");
            theWinner=winner;
            return false;
        }
        boolean avaliable=false;
        for (int i = 0; i < board.length; i++) {
            if (board[i]==" "){avaliable=true;}
        }
        if (!avaliable){
            System.out.println("both of you are equally bad");
            theWinner="_";
            return false;
        }
        return true;
    }

    public void print(){
        System.out.println("    1   2   3  ");
            for (int i = 0; i < 3; i++){
                System.out.println("  +---+---+---+");
                System.out.println("ABC".charAt(i) + " | " + board[i*3] + " | " + board[i*3+1] + " | " + board[i*3+2] + " |");
            }
            System.out.println("  +---+---+---+");
    }
}