class Solution {
    public boolean canWeAllocateCandies(int[] candies, int mid, long k){
        long count=0;

        for(int i=0;i<candies.length;i++){
            count=count+candies[i]/mid;                
            if(count>=k){
                return true;
            }
        }
        if(count>=k){
            return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        int max=Integer.MIN_VALUE;

        for(int i=0;i<candies.length;i++){
            if(max<candies[i])
                max=candies[i];
        }
        int res=0;
        int l=1, h=max,mid;
        while(l<=h){
            mid=(l+h)/2;

            if(canWeAllocateCandies(candies, mid, k)){
                res=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }

        return res;
    }
}