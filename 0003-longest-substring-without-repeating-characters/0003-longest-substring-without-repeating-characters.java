class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int l=0,r=0, maxl=0;
        String sb="";
        while(r<s.length()){
            
            if(hs.contains(s.charAt(r))){
                while(l<r && hs.contains(s.charAt(r))){
                    hs.remove(s.charAt(l));
                l=l+1;
                }  

            }
            hs.add(s.charAt(r));
                            maxl=Math.max(maxl, r-l+1);
                            r=r+1;

        }
        
    
    return maxl;
}
}