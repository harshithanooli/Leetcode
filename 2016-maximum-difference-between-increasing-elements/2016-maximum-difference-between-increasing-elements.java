class Solution {
    public int maximumDifference(int[] nums) {
       // int[] max=new int[nums.length];
        int min=nums[0];
        int res=nums[0]-min;
        
        for(int i=0;i<nums.length;i++){
            res=Math.max(res, nums[i]-min);
            min=Math.min(min, nums[i]);
        }

        return res<=0 ? -1:res;
    }
}