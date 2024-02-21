package games.UltimateTicTacToe;

public class UltimateTicTacToeAI {
    static int possibleTimelines = 0;
    static int[][] priority = new int[9][9];
    public static int[] calculateMove(String[][] board, String me, int lastMiniGame){
        int[] choice = {0,0};
        String them = " ";
        boolean firstMove = true;

        for (int b = 0; b < 9; b++){
            for (int i = 0; i < 9; i++){
                if (board[b][i] != me && board[b][i] != " "){
                    firstMove = false;
                    if (board[b][i] == "█"){
                        them = board[b][i];
                    }
                }
                priority[b][i] = ((board[b][i] == " ") ? 0 : -9999999);
                if (lastMiniGame != -1 && b != lastMiniGame) {priority[b][i] = -999999999;}
            }
        }

        possibleTimelines = 0;
        if (firstMove){
            choice[0] = 4;
            choice[1] = 2;
        } else {
            if (lastMiniGame == -1){
                // Entire Grid Reach
                for (int b = 0; b < 9; b++){
                    for (int i = 0; i < 9; i++){
                        if (board[b][i] == " "){
                            board[b][i] = me;
                            priority[b][i] = path(board, me, them, lastMiniGame, 1, lastMiniGame);
                            board[b][i] = " ";
                        }
                    }
                }
           } else {
                // Mini Grid Reach
                for (int i = 0; i < 9; i++){
                    if (board[lastMiniGame][i] == " "){
                            board[lastMiniGame][i] = me;
                            priority[lastMiniGame][i] = path(board, me, them, lastMiniGame, 1, lastMiniGame);
                            board[lastMiniGame][i] = " ";
                    }
                }
            }

        }

        System.out.println(possibleTimelines + " possible timelines tested");
        int[] bestMove = {0, 0};
        for (int b = 0; b < 9; b++){
            for (int i = 0; i < 9; i++){
                if (priority[b][i] > priority[bestMove[0]][bestMove[1]]){
                    bestMove[0] = b; bestMove[1] = i;
                }
            }
        }
        
        return choice;
    }

    public static int path(String[][] board, String me, String them, int lastMiniGame, int depth, int goodness){
        possibleTimelines += 1;
        String[][] workboard = board;
        int workGoodness = goodness;
        if (depth < 3){
            String iAm = (depth % 2 == 0) ? me : them;
            if (lastMiniGame == -1){
                // Entire Grid Reach
                for (int b = 0; b < 9; b++){
                    for (int i = 0; i < 9; i++){
                        if (board[b][i] == " "){
                            workboard[b][i] = iAm;

                            boolean avaliable=false;
                            for (int ie = 0; ie < 9; ie++) {
                                if (board[b][i]==" "){avaliable=true;}
                            }

                            workGoodness = path(workboard, me, them, avaliable ? i : -1, depth, workGoodness);
                            workboard[b][i] = " ";
                        }
                    }
                }
           } else {
                // Mini Grid Reach
                for (int i = 0; i < 9; i++){
                    if (board[lastMiniGame][i] == " "){
                        workboard[lastMiniGame][i] = iAm;

                        boolean avaliable=false;
                        for (int ie = 0; ie < 9; ie++) {
                            if (board[lastMiniGame][i]==" "){avaliable=true;}
                        }
                        
                        workGoodness = path(workboard, me, them, avaliable ? i : -1, depth, workGoodness);
                        workboard[lastMiniGame][i] = " ";
                    }
                }
            }
        } else {
            UltimateTicTacToeBoard calculateBoard = new UltimateTicTacToeBoard();
            calculateBoard.setBoard(workboard);
            if (calculateBoard.theWinner == me){
                //good move
                return 500;
            } else if (false) { //need to add "or wins a smaller board"
                return 100;
            } else {
                return -10;
            }
        }

        return workGoodness;
    }






    static String[] insults = {
        " put insults here",
    };

    public static void insult(String player){
        // Demotivation of your opponent appears to be a viable strategy in times of desperation.
        System.out.println("\033[1;97m" + player + insults[(int) Math.round(Math.random() * (insults.length-1))] + "\033[0m");
    }
}
