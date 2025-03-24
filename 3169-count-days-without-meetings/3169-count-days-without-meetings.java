class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (x,y)-> Integer.compare(x[0], y[0]));
        int res=meetings[0][0]-1;
        int max=meetings[0][1];
        for(int i=0;i<meetings.length;i++)
            System.out.println(Arrays.toString(meetings[i]));
        for(int i=1;i<meetings.length;i++){
            if(meetings[i][0]>max){
                res=res+meetings[i][0]-max-1;
            }
            max=Math.max(max, meetings[i][1]);
        }

        res=res+(days-max);
        return res;
    }
}