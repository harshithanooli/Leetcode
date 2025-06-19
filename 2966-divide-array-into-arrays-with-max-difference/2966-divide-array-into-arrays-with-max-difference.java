class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] arr=new int[3];
        int[][] res=new int[n/3][3];
        int i=0, count=0;
        while(count<(n/3)){
            arr=new int[3];
            if(nums[i+1]-nums[i]<=k && nums[i+2]-nums[i]<=k && nums[i+2]-nums[i+1]<=k){
            arr[0]=nums[i];
            arr[1]=nums[i+1];
            arr[2]=nums[i+2];
            res[count]=arr;
            }
            else{
                return new int[0][0];
            }
            count++;
            i=i+3;
        }

        return res;
    }
}