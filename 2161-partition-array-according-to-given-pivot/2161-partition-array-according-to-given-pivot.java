class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res=new int[nums.length];
        int i=0, j=0;
        while(i<nums.length){
            if(nums[i]<pivot){
                res[j]=nums[i];
                j++;
            }
            i++;
        }

        i=0;
        while(i<nums.length){
            if(nums[i]==pivot){
                res[j]=pivot;
                j++;
            }
            i++;
        }
        i=0;
        while(i<nums.length){
            if(nums[i]>pivot){
                res[j]=nums[i];
                j++;
            }
            i++;
        }

        return res;
    }
}