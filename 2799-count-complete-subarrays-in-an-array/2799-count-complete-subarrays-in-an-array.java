class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int n:nums){
            hs.add(n);
        }

        int count=hs.size();
        int res=0;
        for(int i=0;i<nums.length;i++){

            hs=new HashSet<>();
            hs.add(nums[i]);
            if(hs.size()==count){
                res=res+nums.length-i;
            }
            else{
                for(int j=i+1;j<nums.length;j++){
                    hs.add(nums[j]);
                    if(hs.size()>=count){
                        res=res+nums.length-j;
                        break;
                    }
                }
            }
        }

        return res;
    }
}