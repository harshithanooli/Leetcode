class Solution {

    public int getMaxAmount(int[] arr, int n){
        int[] dp=new int[n-1];
        dp[0]=arr[0];

        for(int i=1;i<n-1;i++){
            int pick=arr[i];
            if(i>1){
                pick = (dp[i-2]+pick);
            }
            int notPick=dp[i-1];

            dp[i]=Math.max(pick, notPick);
        }
        return dp[n-2];

    }
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;                                                                 
        }
        if(nums.length==1){
            return nums[0];
        }
        int n=nums.length;
        int[] firstIncl = new int[n-1];
        int[] secondIncl = new int[n-1];

        for(int i=0;i<n-1;i++){
            firstIncl[i]=nums[i];
            secondIncl[i]=nums[i+1];
        }
        System.out.println(Arrays.toString(firstIncl));
        System.out.println(Arrays.toString(secondIncl));
        int oneEnd = getMaxAmount(firstIncl,n);
        int otherEnd = getMaxAmount(secondIncl,n);
        System.out.println(oneEnd + " : " +otherEnd);
        return Math.max(oneEnd, otherEnd);

    }
}