class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm=new HashMap<>();

        hm.put(nums[0],1);
        int res=0;
        int pSum=nums[0];
        for(int i=1;i<nums.length;i++){
            pSum=pSum+nums[i];
            
            if(hm.containsKey(pSum-k)){
                res=res+hm.getOrDefault(pSum-k,0);
            }
            hm.put(pSum,hm.getOrDefault(pSum, 0)+1);
        }
        res=res+hm.getOrDefault(k,0);
        return res;

    }
}