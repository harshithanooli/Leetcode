class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        
        HashMap<Long, Long> hm=new HashMap<>();
        long res=0;
        long pSum=0;
        hm.put(0L,1L);
        

        for(int i=0;i<nums.size();i++){
            
                pSum=pSum+(nums.get(i)%modulo==k ? 1:0);
            
            
                res=res+hm.getOrDefault((pSum-k+modulo)%modulo,0L);
            
            
            hm.put(pSum%modulo, hm.getOrDefault(pSum%modulo,0L)+1L);
        }
        return res;
    }
}