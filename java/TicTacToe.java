import java.util.Scanner;

public class TicTacToe {
    private enum Value{X,O,EMPTY};
    private Value[][] board = new Value[3][3];
    private int move=0;
    public TicTacToe() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                board[i][j] = Value.EMPTY;
            }
        }
    }
    public int checkWin() {
        if(board[0][0]==Value.X && board[0][1]==Value.X && board[0][2]==Value.X) {
            return 1;
        }
        else if(board[1][0]==Value.X && board[1][1]==Value.X && board[1][2]==Value.X) {
            return 1;
        }
        else if(board[2][0]==Value.X && board[2][1]==Value.X && board[2][2]==Value.X) {
            return 1;
        }
        else if(board[0][0]==Value.X && board[1][0]==Value.X && board[2][0]==Value.X) {
            return 1;
        }
        else if(board[0][1]==Value.X && board[1][1]==Value.X && board[2][1]==Value.X) {
            return 1;
        }
        else if(board[0][2]==Value.X && board[1][2]==Value.X && board[2][2]==Value.X) {
            return 1;
        }
        else if(board[0][0]==Value.X && board[1][1]==Value.X && board[2][2]==Value.X) {
            return 1;
        }
        else if(board[0][2]==Value.X && board[1][1]==Value.X && board[2][0]==Value.X) {
            return 1;
        }

        else if(board[0][0]==Value.O && board[0][1]==Value.O && board[0][2]==Value.O) {
            return 2;
        }
        else if(board[1][0]==Value.O && board[1][1]==Value.O && board[1][2]==Value.O) {
            return 2;
        }
        else if(board[2][0]==Value.O && board[2][1]==Value.O && board[2][2]==Value.O) {
            return 2;
        }
        else if(board[0][0]==Value.O && board[1][0]==Value.O && board[2][0]==Value.O) {
            return 2;
        }
        else if(board[0][1]==Value.O && board[1][1]==Value.O && board[2][1]==Value.O) {
            return 2;
        }
        else if(board[0][2]==Value.O && board[1][2]==Value.O && board[2][2]==Value.O) {
            return 2;
        }
        else if(board[0][0]==Value.O && board[1][1]==Value.O && board[2][2]==Value.O) {
            return 2;
        }
        else if(board[0][2]==Value.O && board[1][1]==Value.O && board[2][0]==Value.O) {
            return 2;
        }
        return 0;
    }
    public void printBoard() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(board[i][j]==Value.EMPTY) {
                    System.out.print(" " + (3*i+j+1) + " " + "|");
                }
                else if(board[i][j]==Value.X) {
                    System.out.print(" " + "X" + " " + "|");
                }
                else if(board[i][j]==Value.O) {
                    System.out.print(" " + "O" + " " + "|");
                }
            }
            System.out.println();
        }
    }
    public void introduction() {
        System.out.println("This is a Tic-Tac-Toe game for 2 players.");
        System.out.println("1st player use X and 2nd player use O, choose a EMPTY cell by a integer value.");
    }
    public void game(TicTacToe g) {
        Scanner scanner=new Scanner(System.in);
        g.printBoard();
        while(true) {
            move+=1;
            int k=scanner.nextInt();
            int i,j;
            if(k<1 || k>9) {
                System.out.println("Illegal position, please choose a EMPTY space.");
                g.printBoard();
                move-=1;
                continue;
            }
            else if(k>=1 && k<=3) {
                i=0;
                j=k-1;
            }
            else if(k>=4 && k<=6) {
                i=1;
                j=k-4;
            }
            else {
                i=2;
                j=k-7;
            }
            if(g.board[i][j] != Value.EMPTY) {
                System.out.println("Illegal position, please choose a EMPTY space.");
                g.printBoard();
                move-=1;
                continue;
            }
            if(move%2==1) g.board[i][j]=Value.X;
            else g.board[i][j]=Value.O;
            g.printBoard();
            int win=g.checkWin();
            if(win==1) {
                System.out.println("P1 win!");
                break; 
            }
            else if(win==2) {
                System.out.println("P2 win!");
                break;
            }
            if(move==9) {
                System.out.println("Draw!");
                break;
            }
        }
        scanner.close();
    }
    public static void main(String[] args) {
        TicTacToe g = new TicTacToe();
        g.introduction();
        g.game(g);
    }
}