class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int min=Integer.MAX_VALUE;
        int n=intervals.length;
        int i=1;
        Arrays.sort(intervals, Arrays::compare);
        int res=0;
        min=intervals[0][1];

        while(i<n){
            if(intervals[i][0]>=min){
                min=intervals[i][1];
            }
            else{
                min=Math.min(intervals[i][1], min);
                res++;
            }
            i++;
        }
        return res;
    }
}