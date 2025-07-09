class Solution {

    public void dfs(int[][] heights, boolean[][] visited, int i, int j, int r, int c){
        visited[i][j]=true;
        int[] dr={0,-1,0,1};
        int[] dc={-1,0,1,0};

        for(int k=0;k<dr.length;k++){
            
            int a = i+dr[k];
            int b = j+dc[k];
            if(a>=0 && a<r && b>=0 && b<c){
                if(!visited[a][b] && heights[i][j] <= heights[a][b])
                   dfs(heights, visited, a, b, r, c);
            }
        }

        return;
    }   
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] pacificVisited = new boolean[r][c];
        boolean[][] atlanticVisited = new boolean[r][c];
        for(int i=0;i<c;i++){
            dfs(heights, pacificVisited, 0, i, r, c);
            dfs(heights, atlanticVisited,r-1, i, r, c);
        }

        for(int i=0;i<r;i++){
            dfs(heights, pacificVisited, i, 0, r, c);
            dfs(heights, atlanticVisited, i, c-1, r, c);
        }

        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         if(!pacificVisited[i][j]){
        //             if(dfs(heights, pacificVisited, i, j, r, c)){
        //                 pacificVisited[i][j]=true;
        //             }
        //         }
        //         if(!atlanticVisited[i][j]){
        //             if(dfs(heights, atlanticVisited, i, j, r, c)){
        //                 atlanticVisited[i][j]=true;
        //             }
        //         }
        //     }
        // }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    res.add(new ArrayList<Integer>(Arrays.asList(i,j)));
                }
            }
        }

        return res;

    }
}