class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] carPairs = new int[position.length][2];
        int res = 0;
        for(int i=0;i<position.length;i++){
            carPairs[i][0]=position[i];
            carPairs[i][1]=speed[i];
        }

        Arrays.sort(carPairs, (a,b) -> Integer.compare(b[0],a[0]));

        double[] timeTaken = new double[position.length];

        for(int i=0;i<carPairs.length;i++){
            timeTaken[i] = (double)(target-carPairs[i][0])/carPairs[i][1];
        }
        double max = timeTaken[0];
        for(int i=0;i<timeTaken.length-1;i++){
            if(max<timeTaken[i+1]){
                max=timeTaken[i+1];
                res++;
            }
        }

        return res+1;
    }
}