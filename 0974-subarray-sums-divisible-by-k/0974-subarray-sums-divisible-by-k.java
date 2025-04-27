class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        
        int res=0;
        int pSum=nums[0];
        if(pSum%k==0){
            res=res+1;
        }
        if(pSum%k<0){
            hm.put(pSum%k+k, 1);
        }
        else{
            hm.put(pSum%k,1);
        }
        for(int i=1;i<nums.length;i++){
            pSum=pSum+nums[i];
            int rem=pSum%k;
            if(rem==0){
                res=res+1;
            }
            if(rem<0){
                rem=rem+k;
            }
            if(hm.containsKey(rem)){
                res=res+hm.get(rem);
            }
            
            hm.put(rem, hm.getOrDefault(rem,0)+1);
        }
        return res;
    }
}