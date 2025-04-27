class Solution {
    public int countSubarrays(int[] nums) {
        int[] arr=new int[3];
        arr[0]=nums[0];
        arr[1]=nums[1];
        arr[2]=nums[2];
        int res=0;
        int mid= Math.abs(arr[1])<2 ? arr[1]:arr[1]/2;
        if(arr[1]%2==0){
            
            if(mid == (arr[0]+arr[2])){
                res=res+1;
            }
        }
        for(int i=3;i<nums.length;i++){
           
            arr[0]=arr[1];
            arr[1]=arr[2];
            arr[2]=nums[i];
            if(arr[1]%2==0){
                mid= Math.abs(arr[1])<2 ? arr[1]:arr[1]/2;
                if(mid == (arr[0]+arr[2])){
                    res=res+1;
                }
            }
        }
        return res;
    }
}