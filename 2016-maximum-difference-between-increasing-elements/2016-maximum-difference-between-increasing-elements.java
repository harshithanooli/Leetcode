class Solution {
    public int maximumDifference(int[] nums) {
        int[] max=new int[nums.length];
        int[] min=new int[nums.length];
        min[0]=nums[0];
        int res=0;
        for(int i=1;i<nums.length;i++){
            min[i]=Math.min(min[i-1], nums[i]);
        }

        max[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            max[i]=Math.max(nums[i+1], nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            res=Math.max(res, max[i]-min[i]);
        }

        return res<=0 ? -1:res;
    }
}