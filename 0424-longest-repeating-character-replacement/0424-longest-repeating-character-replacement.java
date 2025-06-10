class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm=new HashMap<>();
        int l=0, r=0, res=0;
        int maxfre=0;
        while(r<s.length()){
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r),0)+1);
            maxfre=Math.max(maxfre, hm.get(s.charAt(r)));

            while((r-l+1)-maxfre > k){
                hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                l=l+1;
            }
            res=Math.max(res, (r-l+1));
            
            r=r+1;
        }
        return res;
    }
}