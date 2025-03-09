class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n=grid.length;
        long sumOfGrid=0;
        long sumOfGridSquares=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sumOfGrid=sumOfGrid+grid[i][j];
                sumOfGridSquares+=grid[i][j]*grid[i][j];
            }
        }
        n=(n*n);
        long sumOfN=(n*(n+1))/2;
        long sumOfNSquares=(n*(n+1)*(2*n+1))/6;

        long s2=sumOfNSquares-sumOfGridSquares;
        long s1=sumOfN-sumOfGrid;
        long s3=s2/s1;

        int[] res=new int[2];
        res[1]=(int)((s3+s1)/2);
        res[0]=(int)((s3-s1)/2);
        return res;

    }
}