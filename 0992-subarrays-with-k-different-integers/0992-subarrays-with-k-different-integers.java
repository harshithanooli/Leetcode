class Solution {
    public int subArraysWithAtmostDistinct(int[] nums, int k){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int r=0, l=0, n=nums.length;
        int res=0;
        while(r<n){
            hm.put(nums[r], hm.getOrDefault(nums[r],0)+1);

            while(hm.size()>k){
                hm.put(nums[l], hm.get(nums[l])-1);
                if(hm.get(nums[l])==0)
                    hm.remove(nums[l]);
                l++;
            }

            res += (r-l+1);
            r++;
        }
        return res;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArraysWithAtmostDistinct(nums, k) - subArraysWithAtmostDistinct(nums, k-1);
    }
}