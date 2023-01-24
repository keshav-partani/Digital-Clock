public class RatInAMaze {
    
    public static boolean ratinmaze(int arr[][]){
        int n = arr.length;
        int path[][] = new int[n][n];
        return solveMaze(arr, 0, 0, path);
    }

    public static boolean solveMaze(int[][] arr, int i, int j, int[][] path) {
        int n = arr.length;
        if(i<0 || i>= n || j<0 || j>=n || arr[i][j]==0 || path[i][j]==1){
            return false;
        }

        path[i][j] = 1;

        //Destination
        if(i == n-1 && j == n-1){
            path[i][j] = 0;
            return true;
        }

        boolean pathPossible = false;

        //top
        if(solveMaze(arr, i-1, j, path)){
            pathPossible = true; 
        }        
        //right
        else if (solveMaze(arr, i, j+1, path)){
            pathPossible = true;
        }
        //down
        else if (solveMaze(arr, i+1, j, path)){
            pathPossible = true;
        }
        //left
        else if(solveMaze(arr, i, j-1, path)){
            pathPossible = true;
        }

        return pathPossible;
    }
    
    public static void main(String[] args) {
        int [][] maze = {{1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1}};
        boolean ans = ratinmaze(maze);
        System.out.println(ans);
    }
}
