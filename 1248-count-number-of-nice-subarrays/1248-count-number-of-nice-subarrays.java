class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }
            else{
                nums[i]=1;
            }
        }
        return getCount(nums, k) - getCount(nums, k-1);
    }
    public static int getCount(int[] nums, int goal){
        int l=0, r=0, sum=0, count=0;
        if(goal<0)
        return 0;
        while(r<nums.length){
            sum=sum+nums[r];
            while(sum>goal){
                sum=sum-nums[l];
                l=l+1;
            }
            count=count+(r-l+1);
            r=r+1;
        }
        return count;
    }
}