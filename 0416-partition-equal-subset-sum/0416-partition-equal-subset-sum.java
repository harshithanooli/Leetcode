class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)
            return false;

        boolean dp[][]=new boolean[nums.length][sum/2+1];
        if(nums[0]<=sum/2){
            dp[0][nums[0]]=true;
        }
        for(int i=0;i<=nums.length-1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<=nums.length-1;i++){
            for(int j=1;j<=sum/2;j++){
                boolean notTake=dp[i-1][j];

                boolean take=false;

                if(nums[i]<=j){
                    take=dp[i-1][j-nums[i]];
                }

                dp[i][j]=take||notTake;
            }     
        }

        return dp[nums.length-1][sum/2];

    }
}