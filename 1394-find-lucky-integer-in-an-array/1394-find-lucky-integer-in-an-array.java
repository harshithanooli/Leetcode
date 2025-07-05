class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        int max = -1;
        int res =-1 ;

        for(int i=0;i<arr.length;i++){
            max=Math.max(max, arr[i]);
            count[arr[i]]++;
        }

        for(int i=max;i>=1;i--){
            if(i==count[i]){
                return i;
            }
        }

        return res;
    }
}