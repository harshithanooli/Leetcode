class Solution {
    public int maxDifference(String s) {
        int[] count=new int[26];
        int maxOdd=0, maxEven=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(count[i]!=0 && count[i]%2==0){
                maxEven=Math.min(maxEven, count[i]);
            }
            else{
                maxOdd=Math.max(maxOdd, count[i]);
            }
        }
            
        
        return maxOdd-maxEven;
    }
}