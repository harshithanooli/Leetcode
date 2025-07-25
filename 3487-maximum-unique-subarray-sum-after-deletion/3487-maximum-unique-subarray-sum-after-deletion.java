class Solution {
    public int maxSum(int[] nums) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        int res = 0;

        boolean positiveExists = false;
        int max = nums[0];
        for(int num: nums){
            if(num>=0){
                positiveExists = true;
                break;
            }
            max=Math.max(max, num);
        }

        if(!positiveExists)
            return max;

        int sum=0;
        for(int i=0;i<nums.length;i++){

            if(nums[i]>=0 && hm.getOrDefault(nums[i],0)==0){
                sum = sum+nums[i];
                res= Math.max(res, sum);
            }

            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }

        return res;

    }
}