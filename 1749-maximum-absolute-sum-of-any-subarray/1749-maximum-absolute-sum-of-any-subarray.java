class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currSum= 0, maxSum = Integer.MIN_VALUE;
        int currSumNeg=0, minSum=Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (currSum + nums[i] < 0) {
                currSum = 0;

            } else {
                currSum += nums[i];
            }
            if(currSumNeg+nums[i]<0){
                currSumNeg+=nums[i];
            }
            else{
                currSumNeg=0;
            }
            maxSum = Math.max(maxSum, currSum);
            minSum=Math.min(minSum, currSumNeg);
        }

        return Math.max(Math.abs(minSum), Math.abs(maxSum));
    }
}