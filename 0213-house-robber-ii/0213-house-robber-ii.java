class Solution {

    public int getMaxAmount(int[] arr, int n){
        //int[] dp=new int[n-1];
        int prev=arr[0];
        int prev2=0, curr=0;

        for(int i=1;i<n-1;i++){
            int pick=arr[i];
            if(i>1){
                pick = (prev2+pick);
            }
            int notPick=prev;

            curr=Math.max(pick, notPick);
            prev2=prev;
            prev=curr;
        }
        return prev;

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
        
        int oneEnd = getMaxAmount(firstIncl,n);
        int otherEnd = getMaxAmount(secondIncl,n);
        System.out.println(oneEnd + " : " +otherEnd);
        return Math.max(oneEnd, otherEnd);

    }
}