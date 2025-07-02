class Solution {
    public void dfs(int i, int j, int[][] board){
        board[i][j]=-1;

        int[] dirRow = {0,-1,0,1};
        int[] dirCol = {-1,0,1,0};

        for(int k=0;k<dirRow.length;k++){
            int x= i+dirRow[k], y=j+dirCol[k];

            if(x>=0 && x<board.length && y>=0 && y<board[0].length && board[x][y]!=-1 && board[x][y]==1){
                dfs(x,y,board);
            }
            
        }

        return;
    }
    public int numEnclaves(int[][] board) {
        int m=board.length, n = board[0].length;

        //1st and last column
        for(int i=0;i<n;i++){
            if(board[0][i]==1){
                dfs(0,i,board);
            }
            if(board[m-1][i]==1){
                dfs(m-1,i, board);
            }
        }


        for(int i=0;i<m;i++){
            if(board[i][0]==1){
                dfs(i,0,board);
            }
            if(board[i][n-1]==1){
                dfs(i, n-1, board);
            }
        }
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                   res++;
                }
            }
        }

        return res;
    }
}