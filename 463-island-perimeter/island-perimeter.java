class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {

    public void dfs(boolean[][] visited, int[][] grid, int i, int j, int[] result){
        Pair p =new Pair(i,j);
        if(visited[i][j] || grid[i][j]==0){
            return;
        }
        if(grid[i][j]==1){
            visited[i][j]=true;
        }

        int[] dirRow = {0,-1,0,1};
        int[] dirCol = {-1,0,1,0};

        for(int k=0;k<dirRow.length;k++){
            int a=i+dirRow[k];
            int b=j+dirCol[k];

            if(a<0 || a>grid.length-1){
           
                result[0]=result[0]+1;
            }

            if(b<0 || b>grid[0].length-1){
            
                result[0]=result[0]+1;
            }

            if(a>=0 && b>=0 && a<grid.length && b<grid[0].length && grid[a][b]==0){
            
                result[0]=result[0]+1;
            }

            if(a>=0 && b>=0 && a<grid.length && b<grid[0].length && grid[a][b]==1){
                dfs(visited, grid,a,b,result);
            }
        }
        return;
    }
    public int islandPerimeter(int[][] grid) {
        
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        
        int[] result={0};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1){
                    dfs(visited, grid, i, j, result);
                }
            }
        }
       
        return result[0];
    }
}