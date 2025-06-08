class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, l=0, n=s.length();
        HashMap<Character, Integer> hm=new HashMap<>();

        for(int i=0;i<n;i++){
            if(hm.containsKey(s.charAt(i)) && l<=hm.get(s.charAt(i))){
                l=hm.get(s.charAt(i))+1;
            }

            res=Math.max(res, i-l+1);
            hm.put(s.charAt(i), i);
        }
        
        return res;
    }
}