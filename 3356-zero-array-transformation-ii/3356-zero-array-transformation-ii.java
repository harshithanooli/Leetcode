class Solution {
    public boolean check(int mid, int[] nums, int[][] queries){
        int[] diff=new int[nums.length+1];

        for(int i=0;i<mid;i++){
            int l=queries[i][0], r=queries[i][1], val=queries[i][2];

            diff[l]=diff[l]+val;
            diff[r+1]=diff[r+1]-val;
        }

        for(int i=1;i<diff.length;i++){
            diff[i]=diff[i]+diff[i-1];
        }

        for(int i=0;i<nums.length;i++){
            if(diff[i]<nums[i])
                return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int l=0, r=queries.length;
        int res=-1;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(check(mid, nums, queries)){
                res=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
}