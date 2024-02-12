package games.TicTacToe;

public class TicTacToeAI {
    public static int calculateMove(String[] board, String me, int filledSquares){
        int[] priority = new int[9];
        for (int i = 0; i < board.length; i++){
            if (board[i]!=" "){priority[i]-=9999999;}
            if (filledSquares % 2 == 1) {if (i==0 || i==2 || i==6 || i==8){priority[i]+=5;}}
                // else if (i==1 || i==3 || i==5 || i==7){priority[i]+=2;}
        }
        if (filledSquares==1){priority[4]+=10;}
        for (int i = 0; i < 3; i++){
            if (board[i*3+0]==board[i*3+1] && board[i*3+0]!=" ") {priority[i*3+2]+=100;}
            if (board[i*3+0]==board[i*3+2] && board[i*3+0]!=" ") {priority[i*3+1]+=100;}
            if (board[i*3+1]==board[i*3+2] && board[i*3+1]!=" ") {priority[i*3+0]+=100;}
            if (board[i]==board[i+3] && board[i]!=" ") {priority[i+6] += 100;}
            if (board[i]==board[i+6] && board[i]!=" ") {priority[i+3] += 100;}
            if (board[i+3]==board[i+6] && board[i+3]!=" ") {priority[i] += 100;}

        }
        if (board[0]==board[4] && board[0]!=" "){if (board[0]!=me) {priority[8] += 100;} else {priority[8] += 5;}}
        if (board[0]==board[8] && board[0]!=" "){if (board[0]!=me) {priority[4] += 100;} else {priority[4] += 5;}}
        if (board[4]==board[8] && board[4]!=" "){if (board[4]!=me) {priority[0] += 100;} else {priority[0] += 5;}}
            
        if (board[2]==board[4] && board[2]!=" "){if (board[2]!=me) {priority[6] += 100;} else {priority[6] += 5;}}
        if (board[2]==board[6] && board[2]!=" "){if (board[2]!=me) {priority[4] += 100;} else {priority[4] += 5;}}
        if (board[4]==board[6] && board[4]!=" "){if (board[4]!=me) {priority[2] += 100;} else {priority[2] += 5;}}

        if (board[1]==board[3] && board[1]!=me && board[1]!=" ") {priority[0] += 5; priority[4] += 15;}
        if (board[1]==board[5] && board[5]!=me && board[5]!=" ") {priority[2] += 5; priority[4] += 15;}
        if (board[3]==board[7] && board[3]!=me && board[3]!=" ") {priority[6] += 5; priority[4] += 15;}
        if (board[5]==board[7] && board[7]!=me && board[7]!=" ") {priority[8] += 5; priority[4] += 15;}

        if (board[0]==board[5] && board[0]!=me && board[0]!=" ") {priority[2] += 15;}
        if (board[0]==board[7] && board[0]!=me && board[0]!=" ") {priority[6] += 15;}
        if (board[2]==board[3] && board[2]!=me && board[2]!=" ") {priority[0] += 15;}
        if (board[2]==board[7] && board[2]!=me && board[2]!=" ") {priority[8] += 15;}
        if (board[6]==board[1] && board[6]!=me && board[6]!=" ") {priority[0] += 15;}
        if (board[6]==board[5] && board[6]!=me && board[6]!=" ") {priority[8] += 15;}
        if (board[8]==board[1] && board[8]!=me && board[8]!=" ") {priority[2] += 15;}
        if (board[8]==board[3] && board[8]!=me && board[8]!=" ") {priority[6] += 15;}

        if (board[2]==board[6] && board[2]!=me && board[2]!=" ") {priority[1] += 15; priority[3] += 15; priority[5] += 15; priority[7] += 15;}
        if (board[0]==board[8] && board[0]!=me && board[0]!=" ") {priority[1] += 15; priority[3] += 15; priority[5] += 15; priority[7] += 15;}
            

        int bestMove = -1;
        int bestValue = -1;
        for (int i = 0; i < board.length; i++){
            if (priority[i]>bestValue){
                bestValue=priority[i];
                bestMove=i;
            }
        }

        // System.out.println("THE BIG BRAIN AI MADE A MOVE");
        // System.out.println(bestMove);
        // System.out.println("WITH PRIORITY");
        // System.out.println(bestValue);
        // System.out.println("THE PRIORITY IS CURRENTLY");
        // for (int i = 0; i < board.length; i++){System.out.println(priority[i]);}

        return bestMove;
    }
}
