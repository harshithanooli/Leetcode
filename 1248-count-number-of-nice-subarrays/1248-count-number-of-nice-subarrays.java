class Solution {
    public int getCount(int[] nums, int k){
        int res=0;
        int count=0;

        int r=0, l=0, n=nums.length;

        while(r<n){
            if(nums[r]%2==1){
                count++;
            }

            while(count>k){
                if(l<n && nums[l]%2==1){
                    count--;
                }
                l++;
            }
            if(count<=k){
                res=res + r-l+1;
            }
            r++;
            
        }

        return res;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return getCount(nums, k)-getCount(nums, k-1);
    }
}