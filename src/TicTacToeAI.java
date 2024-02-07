public class TicTacToeAI {
    public static int calculateMove(String[] board, String me){
        int[] priority = new int[9];
        for (int i = 0; i < board.length; i++){
            if (board[i]!=" "){priority[i]-=9999999;}
            if (i==1 || i==3 || i==5 || i==7){priority[i]+=1;}
        }

        for (int i = 0; i < 3; i++){
            if (board[i*3+0]==board[i*3+1] && board[i*3+0]!=" "){if (board[i*3+0]==me) {priority[i*3+2]+=100;} else {priority[i*3+2]+=5;}}
                if (board[i*3+0]==board[i*3+1]){priority[i*3+2]+=2;}
            if (board[i*3+0]==board[i*3+2] && board[i*3+0]!=" "){if (board[i*3+0]==me) {priority[i*3+1]+=100;} else {priority[i*3+1]+=5;}}
                if (board[i*3+0]==board[i*3+2]){priority[i*3+1]+=2;}
            if (board[i*3+1]==board[i*3+2] && board[i*3+1]!=" "){if (board[i*3+1]==me) {priority[i*3+0]+=100;} else {priority[i*3+0]+=5;}}
                if (board[i*3+1]==board[i*3+2]){priority[i*3+0]+=2;}
            if (board[i]==board[i+3] && board[i]!=" "){if (board[i]==me) {priority[i+6] += 100;} else {priority[i+6] += 5;}}
                if (board[i]==board[i+3]){priority[i+6] += 2;}
            if (board[i]==board[i+6] && board[i]!=" "){if (board[i]==me) {priority[i+3] += 100;} else {priority[i+3] += 5;}}
                    if (board[i]==board[i+6]){priority[i+3] += 2;}
            if (board[i+3]==board[i+6] && board[i+3]!=" "){if (board[i+3]==me) {priority[i] += 100;} else {priority[i] += 5;}}
                if (board[i+3]==board[i+6]){priority[i] += 2;}
        }
        if (board[0]==board[4] && board[0]!=" "){if (board[0]==me) {priority[8] += 100;} else {priority[8] += 5;}}
            if (board[0]==board[4]){priority[8]+=2;}
        if (board[0]==board[8] && board[0]!=" "){if (board[0]==me) {priority[4] += 100;} else {priority[4] += 5;}}
            if (board[0]==board[8]){priority[4]+=2;}
        if (board[4]==board[8] && board[4]!=" "){if (board[4]==me) {priority[0] += 100;} else {priority[0] += 5;}}
            if (board[4]==board[8]){priority[0]+=2;}

        if (board[2]==board[4] && board[2]!=" "){if (board[2]==me) {priority[6] += 100;} else {priority[6] += 5;}}
            if (board[2]==board[4]){priority[6]+=2;}
        if (board[2]==board[6] && board[2]!=" "){if (board[2]==me) {priority[4] += 100;} else {priority[4] += 5;}}
            if (board[2]==board[6]){priority[4]+=2;}
        if (board[4]==board[6] && board[4]!=" "){if (board[4]==me) {priority[2] += 100;} else {priority[2] += 5;}}
            if (board[4]==board[6]){priority[2]+=2;}

        int bestMove = -1;
        int bestValue = -1;
        for (int i = 0; i < board.length; i++){
            if (priority[i]>bestValue){
                bestValue=priority[i];
                bestMove=i;
            }
        }
        System.out.println("THE BIG BRAIN AI MADE A MOVE");
        System.out.println(bestMove);
        System.out.println("WITH PRIORITY");
        System.out.println(bestValue);
        System.out.println("THE PRIORITY IS CURRENTLY");
        for (int i = 0; i < board.length; i++){System.out.println(priority[i]);}

        return bestMove;
    }
}
