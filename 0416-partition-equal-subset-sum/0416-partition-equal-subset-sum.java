class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)
            return false;

        boolean prev[]=new boolean[sum/2+1];
        boolean curr[]=new boolean[sum/2+1];
        if(nums[0]<=sum/2){
            prev[nums[0]]=true;
        }
        

        for(int i=1;i<=nums.length-1;i++){
            for(int j=sum/2;j>=nums[i];j--){
                boolean notTake=dp[i-1][j];

                boolean take=dp[i-1][j-nums[i]];
                

                dp[i][j]=take||notTake;
            }     
        }

        return dp[nums.length-1][sum/2];

    }
}