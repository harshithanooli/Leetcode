class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        
        HashMap<Long, Long> hm=new HashMap<>();
        long res=0;
        long pSum=0;
        hm.put(0L,1L);
        

        for(int i=0;i<nums.size();i++){
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