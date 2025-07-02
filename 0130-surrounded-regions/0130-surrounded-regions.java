class Solution {
    public void dfs(int i, int j, char[][] board){
        board[i][j]='#';

        int[] dirRow = {0,-1,0,1};
        int[] dirCol = {-1,0,1,0};

        for(int k=0;k<dirRow.length;k++){
            int x= i+dirRow[k], y=j+dirCol[k];

            if(x>=0 && x<board.length && y>=0 && y<board[0].length && board[x][y]!='#' && board[x][y]=='O'){
                dfs(x,y,board);
            }
            else{
                continue;
            }  
        }

        return;
    }
    public void solve(char[][] board) {
        int m=board.length, n = board[0].length;

        //1st and last column
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(0,i,board);
            }
            if(board[m-1][i]=='O'){
                dfs(m-1,i, board);
            }
        }


        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }
            if(board[i][n-1]=='O'){
                dfs(i, n-1, board);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#')
                    board[i][j]='O';
            }
        }
    }
}