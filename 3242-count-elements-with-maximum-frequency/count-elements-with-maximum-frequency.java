class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count=new int[101];
        int max=0;
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
            max=Math.max(max, count[nums[i]]);
        }

        int res=0;
        for(int ele:count){
            if (ele==max){
                res = res+ele;
            }
        }

        return res;
    }
}