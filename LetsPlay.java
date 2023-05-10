import java.util.*;

public class LetsPlay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
        char player;
        int f = 0;
        boolean gameOver = false;
        System.out.println("Choose first player move: ");
        player = sc.next().charAt(0);
        while (!gameOver && f == 0) {
            printBoard(board);
            int x, y;
            System.out.println("Enter next move coordinates: ");
            x = sc.nextInt();
            y = sc.nextInt();
            if (board[x][y] == ' ') {
                board[x][y] = player;
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.print("player " + player + " has won");
                    f = 1;
                } else {
                    player = (player == 'x') ? 'o' : 'x';
                }
            } else {
                System.out.println("Invalid move!");
            }
            if (f == 0 && gridCheck(board)) {
                System.out.println("Game tie!");
                break;
            }
        }
        

    }

    public static boolean gridCheck(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    // If there is an empty space on the board, the game is not over
                    return false;
                }
            }
        }
        // If there are no empty spaces on the board, the game is a tie
        return true;
    }

    public static boolean haveWon(char[][] board, char player) {
        for (int i = 0; i < board.length; i++) {
            if ((board[i][0] == player) && (board[i][1] == player) && (board[i][2] == player)) {
                return true;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if ((board[0][i] == player) && (board[1][i] == player) && (board[2][i] == player)) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }

    }

}
