class Solution {
    public int longestOnes(int[] nums, int k) {
        int res=0, zeroCount=0;
        int n=nums.length;
        int r=0, l=0;
        while(r<n){
             if(nums[r]==0){
                zeroCount++;
            }
            while(l<n && zeroCount>k){
                if(nums[l]==0){
                    zeroCount--;
                }
                l++;
            }
            res=Math.max(res, r-l+1);
           
            r++;
        }

        return res;
    }
}