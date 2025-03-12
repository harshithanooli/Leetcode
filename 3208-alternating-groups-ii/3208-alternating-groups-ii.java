class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res=0, n=colors.length,j=0;
        for(int i=1;i<n+k-1;i++){
            if(colors[i%n]==colors[(i-1)%n]){
                j=i;
                continue;
            }

            if(i-j+1>=k){
                res++;
            }
        }

        return res;
    }
}