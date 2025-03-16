class Solution {
    public boolean isRepairPossible(int[] ranks, int cars, long mid){
       long count=0;

        for(int i=0;i<ranks.length;i++){
            count=count+(long)Math.sqrt(mid/ranks[i]);
            if(count>=cars){
                return true;
            }
        }
        if(count>=cars){
            return true;
        }
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int rank:ranks){
            max=Math.max(max, rank);
            min=Math.min(min, rank);
        }

        long l=min, h=(long)min*(long)cars*(long)cars;

        long mid=(l+h)/2;
        long res=h;
        while(l<=h){
            mid=(l+h)/2;

            if(isRepairPossible(ranks, cars, mid)){
                res=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return res;
    }
}