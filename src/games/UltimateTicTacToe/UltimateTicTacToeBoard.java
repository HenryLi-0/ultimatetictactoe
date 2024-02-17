package games.UltimateTicTacToe;

public class UltimateTicTacToeBoard {
    static String[][] board = new String[9][9];
    static String[] winningboards = new String[9];
    String theWinner = " ";

    public UltimateTicTacToeBoard(){
        for (int b = 0; b < 9; b++){
            for (int i = 0; i < 9; i++){board[b][i] = " ";}
            winningboards[b] = "";
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

    public String miniGameStatus(int b){
        String winner = " "; 
        for (int i = 0; i < 3; i++){
            if (board[b][i*3+0]==board[b][i*3+1] && board[b][i*3+0]==board[b][i*3+2] && board[b][i*3+0]!=" "){winner = board[b][i*3+0];}
            if (board[b][i]==board[b][i+3] && board[b][i]==board[b][i+6] && board[b][i]!=" "){winner = board[b][i];}
        }
        if (board[b][0]==board[b][4] && board[b][0]==board[b][8] && board[b][0]!=" "){winner = board[b][0];}
        if (board[b][2]==board[b][4] && board[b][2]==board[b][6] && board[b][2]!=" "){winner = board[b][2];}
        if (winner!=" "){
            winningboards[b]=winner;
        }
        boolean avaliable=false;
        for (int i = 0; i < board[b].length; i++) {
            if (board[b][i]==" "){avaliable=true;}
        }
        if ((!avaliable) && winner == " "){
            winner="█";
        }
        if (winner!=" "){
            if (winner != "█"){
                winningboards[b] = winner;
                for (int i = 0; i < 9; i++){
                    board[b][i] = winner;
                }
            } else {
                for (int i = 0; i < 9; i++){
                    board[b][i] = "█";
                }
            }
        }
        return winner;
    }

    public boolean gameStatus(){
        for (int b = 0; b < 9; b++){
            miniGameStatus(b);
        }

        String winner = "1155"; 
        for (int i = 0; i < 3; i++){
            if (winningboards[i*3+0]==winningboards[i*3+1] && winningboards[i*3+0]==winningboards[i*3+2] && winningboards[i*3+0]!="" && winningboards[i*3+0]!="█"){winner = winningboards[i*3+0];}
            if (winningboards[i]==winningboards[i+3] && winningboards[i]==winningboards[i+6] && winningboards[i]!="" && winningboards[i]!="█"){winner = winningboards[i];}
        }
        if (winningboards[0]==winningboards[4] && winningboards[0]==winningboards[8] && winningboards[0]!="" && winningboards[0]!="█"){winner = winningboards[0];}
        if (winningboards[2]==winningboards[4] && winningboards[2]==winningboards[6] && winningboards[2]!="" && winningboards[2]!="█"){winner = winningboards[2];}
        if (winner!="1155"){
            print(-1);
            System.out.println(winner + " wins!");
            theWinner=winner;
            return false;
        }
        boolean avaliable=false;
        for (int i = 0; i < winningboards.length; i++) {
            if (winningboards[i]==""){avaliable=true;}
        }
        if (!avaliable){
            print(-1);
            System.out.println("both of you are equally bad");
            theWinner="█";
            return false;
        }
        return true;
    }

    public void print(int lastMiniGame){
        System.out.println(" +++++++++++++             +---+---+---+");
        System.out.println(" # A # B # C #   Ultimate  | 1 | 2 | 3 |");
        System.out.println(" +++++++++++++             +---+---+---+");
        System.out.println(" # D # E # F #   Tic Tac   | 4 | 5 | 6 |");
        System.out.println(" +++++++++++++             +---+---+---+");
        System.out.println(" # G # H # I #   Toe       | 7 | 8 | 9 |");
        System.out.println(" +++++++++++++             +---+---+---+");
            for (int i = 0; i < 9; i++){
                if (i % 3 == 0){
                    System.out.println("++===+===+===++===+===+===++===+===+===++"); System.out.println("++===+===+===++===+===+===++===+===+===++");
                } else {
                    System.out.println("++---+---+---++---+---+---++---+---+---++");
                }
                System.out.println("||" + "\033[0m"
                + ((lastMiniGame == ((int) Math.floor(i/3))*3) ? "\033[0;100m" : "")  + " "
                + board[((int) Math.floor(i/3))*3][(i%3)*3] + " | " + board[((int) Math.floor(i/3))*3][(i%3)*3+1] + " | " + board[((int) Math.floor(i/3))*3][(i%3)*3+2] 
                + " " + "\033[0m" + "||" + ((lastMiniGame == ((int) Math.floor(i/3))*3+1) ? "\033[0;100m" : "") + " "
                + board[((int) Math.floor(i/3))*3+1][(i%3)*3] + " | " + board[((int) Math.floor(i/3))*3+1][(i%3)*3+1] + " | " + board[((int) Math.floor(i/3))*3+1][(i%3)*3+2] 
                + " " + "\033[0m" + "||" + ((lastMiniGame == ((int) Math.floor(i/3))*3+2) ? "\033[0;100m" : "") + " "
                + board[((int) Math.floor(i/3))*3+2][(i%3)*3] + " | " + board[((int) Math.floor(i/3))*3+2][(i%3)*3+1] + " | " + board[((int) Math.floor(i/3))*3+2][(i%3)*3+2] 
                + " " + "\033[0m" +"||");
            }
            System.out.println("++===+===+===++===+===+===++===+===+===++");System.out.println("++===+===+===++===+===+===++===+===+===++");
    }
}