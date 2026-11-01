import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Nqueens{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        //solveNQueens(n);
        Nqueens obj = new Nqueens();
List<List<String>> result = obj.solveNQueens(n);
        for (List<String> solution : result) {
    for (String row : solution) {
        System.out.println(row);
    }
    System.out.println();
}

    }

    public List<List<String>> solveNQueens(int n) {
    
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j]='.';
            }
        }
        List<List<String>> finalResult = new ArrayList<>();
        backTrack(board, 0, finalResult);
        return finalResult;
    }


    private void backTrack(char[][] board, int row, List<List<String>> result) {
        if(row == board.length) {
            result.add(construct(board));
            return;
        }

        for(int i=0; i<board.length; i++) {
            if(isValid(board, row, i)) {
                board[row][i] = 'Q';
                backTrack(board, row + 1, result);
                board[row][i] = '.';
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            String row = new String(board[i]);
            result.add(row);
        }
        return result;
    }

    private boolean isValid(char[][] board, int row, int col) {
        for(int i=0; i<row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }       
        for(int i=row-1, j=col+1; i>=0 && j<=board.length-1; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}