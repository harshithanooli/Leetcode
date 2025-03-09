class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int res=Integer.MAX_VALUE;
        int min=0;

        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W'){
                min++;
            }
        }
        res=Math.min(res, min);

        for(int i=1;i<blocks.length();i++){
            if(i>=k && blocks.charAt(i-k)=='W'){
                min--;
            }
            if(blocks.charAt(i)=='W'){
                min++;
            }
            res=Math.min(res, min);
        }


        return res;
    }
}