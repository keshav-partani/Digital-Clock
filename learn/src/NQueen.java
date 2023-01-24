public class NQueen {

    public static void placeNQueen(int n){
        int board[][] = new int[n][n];
        placeQueen(board, 0, n);
    }

    public static void placeQueen(int[][] board, int row, int n){
        if(row==n){
            for(int i = 0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }

        for(int i=0; i<n; i++){
            if(isBoardSafe(board, row, i)){
                board[row][i] = 1;
                placeQueen(board, row+1, n);
                board[row][i] = 0;
            }
        }
    }

    private static boolean isBoardSafe(int[][] board, int row, int col) {
        int n = board.length;
        
        //check for diagonally upward (in left)
        for(int i=row-1, j=col-1; i>=0 && j>=0;  i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        //check for diagonally downward (in right)
        for(int i=row+1, j=col+1; i<n && j<n;  i++, j++){
            if(board[i][j] == 1){
                return false;
            }
        }

        //check for diagonally upward (in right)
        for(int i=row-1, j=col+1; i>=0 && j<n; i--,j++){
            if(board[i][j] == 1){
                return false;
            }
        }

        //check for diagonally downward (in left)
        for(int i=row+1, j=col-1; i<n && j>=0; i++,j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        //check vertically upward
        for(int i=row-1; i>=0; i--){
            if(board[i][col]==1){
                return false;
            }
        }

        //check vertically downward
        for(int i=row+1; i<n; i++){
            if(board[i][col]==1){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        placeNQueen(4);
    }
}
