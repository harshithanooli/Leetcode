class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, l=0, n=s.length();
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            while(l<n && hs.contains(s.charAt(i))){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(i));
            res=Math.max(res, i-l+1);
        }

        return res;
    }
}