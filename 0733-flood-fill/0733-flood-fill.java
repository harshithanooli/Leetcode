class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length, col = image[0].length;
        int[][] res=new int[row][col];


        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                res[i][j] = image[i][j];
        }

        int ogColor = image[sr][sc];

        if(ogColor == color)
            return image;
            
        Queue<List<Integer>> q = new LinkedList<>();

        q.add(new ArrayList<Integer>(Arrays.asList(sr,sc)));

        int[] dirRow = {0,-1,0,1};
        int[] dirCol = {-1,0,1,0};

        while(!q.isEmpty()) {
            List<Integer> l = q.poll();
            int x= l.get(0), y = l.get(1);

            res[x][y] = color;

            for(int i=0;i<dirRow.length;i++){
                if(x+dirRow[i]>=0 && x+dirRow[i]<row && y+dirCol[i]>=0 && y+dirCol[i]<col && res[x+dirRow[i]][y+dirCol[i]]==ogColor){
                    q.add(Arrays.asList(x+dirRow[i], y+dirCol[i]));
                    res[x+dirRow[i]][y+dirCol[i]]=color;
                }
            }

        }

        return res;

        
    }
}