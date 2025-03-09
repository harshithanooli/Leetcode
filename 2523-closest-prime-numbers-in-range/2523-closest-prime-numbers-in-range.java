class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean prime[] = new boolean[right+1];
        for (int i = 0; i <= right; i++)
            prime[i] = true;

        for (int p = 2; p * p <= right; p++) {
            
            if (prime[p] == true) {
                for (int i = p * p; i <= right; i += p)
                    prime[i] = false;
            }
        }
        int[] res={-1,-1};

        int min=Integer.MAX_VALUE;
        int prev=min, prev2=min;
        int j=Math.max(2,left);
        for(;j<=right;j++){
            if(prev2==Integer.MAX_VALUE && prime[j]==true){
                prev2=j;
            }
            if(prev2!=Integer.MAX_VALUE && prev2!=j && prev==Integer.MAX_VALUE && prime[j]==true){
                prev=j;
            }
            if(prev!=Integer.MAX_VALUE && prev2!=Integer.MAX_VALUE){
                break;
            }
        }
        if(prev!=min && prev2!=min){
            if(min>(prev-prev2)){
                        min=prev-prev2;
                        res[0]=prev2;
                        res[1]=prev;
                    }
                    for(j=prev+1;j<=right;j++){
                        if(prime[j]==true){
                            prev2=prev;
                            prev=j;
                            if(min>(prev-prev2)){
                                min=prev-prev2;
                                res[0]=prev2;
                                res[1]=prev;
                            }
                        }
                    }
        }
        

        return res;
    }
}