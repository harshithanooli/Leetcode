class Solution {

    public boolean dfs(int x, int y, int parentX, int parentY, boolean[][] visited, int rows, int cols, char character, char[][] grid){
        visited[x][y]=true;
        int[] dirRow = {0,-1, 0, 1};
        int[] dirCol = {-1, 0, 1, 0};

        for(int i=0;i<dirRow.length;i++){
            
            int a = x+dirRow[i];
            int b= y+dirCol[i];
            if(a<0 || a>=rows || b<0 || b>=cols)
                continue;
            if(grid[a][b]!=character)
                continue;
            if(parentX==a && parentY==b)
               continue;
            
            if(visited[a][b]) return true;
            if(dfs(a, b, x, y, visited, rows, cols, character, grid)){
                    return true;
            }
        }

        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0;i<rows; i++){
            for(int j=0;j<cols;j++){
                
                    if(!visited[i][j]){
                        if(dfs(i, j, -1, -1, visited, rows, cols, grid[i][j], grid)){
                          System.out.println(i + ": "+ j);
                            return true;
                        }
                    }
                
            }
        }   

        return false;
        
    }
}