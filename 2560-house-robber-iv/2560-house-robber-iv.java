class Solution {
    public boolean getMinCapability(int[] nums, int k,int i, int c, int possibleMid){
        if(c>=k){
            return true;         
        }
        if(i<nums.length ){
            
            if( nums[i]<=possibleMid && getMinCapability(nums, k, i+2, c+1,possibleMid)){
                return true;
            }

            if(getMinCapability(nums,k, i+1, c, possibleMid))
            return true;
                
        }
        return false;
        

        // for(int j=0;j<nums.length;j++){
        //     if(nums[j]<=possibleMid){
        //         c++;
        //         j++;
        //     }
        //     if(c>=k){
        //         return true;
        //     }            
        // }

        // if(c>=k){
        //     return true;
        // } 
        // return false;
        
    }
    public int minCapability(int[] nums, int k) {
        int[] res={Integer.MAX_VALUE};
        int finalResult=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min, nums[i]);
            max=Math.max(max, nums[i]);
        }
        int mid;
        while(min<=max){
            mid=(min+max)/2;

            if(getMinCapability(nums, k,0,0, mid)){
                finalResult=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        

        return finalResult;
        
    }
}