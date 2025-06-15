class Solution {
    public boolean isDiffPossible(int[] nums, int diff, int n, int p){
        int minPairs=0;
        for(int i=0;i<n-1;i++){
            if(Math.abs(nums[i+1]-nums[i]) <= diff){
                minPairs++;
                i=i+1;
            }
            if(minPairs>=p){
                return true;
            }
        }

        return minPairs>=p;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n=nums.length;
        int low=0, high=nums[n-1]-nums[0],mid=0;
        int res=0;
        while(low<=high){
            mid=(low+high)/2;
            if(isDiffPossible(nums, mid, n, p))
            {
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return res;
    }
}