class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        if(modulo==1 && k==0){
            return (long)((nums.size()*(nums.size()+1))/2);
        }
        HashMap<Long, Long> hm=new HashMap<>();
        long res=0;
        long pSum=nums.get(0)%modulo==k?1:0;
        hm.put(0L,1L);
        hm.put(pSum,1L);
        if(pSum%modulo==k){
            res=res+1;
        }

        for(int i=1;i<nums.size();i++){
            if(nums.get(i)%modulo==k){
                pSum=pSum+1;
            }
            if(hm.containsKey((pSum-k+modulo)%modulo)){
                res=res+hm.get((pSum-k+modulo)%modulo);
            }
            
            hm.put(pSum%modulo, hm.getOrDefault(pSum%modulo,0L)+1L);
        }
        return res;
    }
}