class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> al=new ArrayList<>();
        int rem=grid[0][0]%x;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                al.add(grid[i][j]);
            if(grid[i][j]%x!=rem){
                return -1;
            }
            }
        }

        Collections.sort(al);

        int median;
        median=al.get(al.size()/2);
        
        int res=0;
        for(int i=0;i<al.size();i++){
            res=res+Math.abs(al.get(i)-median)/x;
        }
        return res;

        
    }
}