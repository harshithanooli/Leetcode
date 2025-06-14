class Solution {

   
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int res=Integer.MAX_VALUE, count=0;
        HashMap<Character, Integer> hmt=new HashMap<>();
        for(int i=0;i<t.length();i++){
            hmt.put(t.charAt(i), hmt.getOrDefault(t.charAt(i),0)+1);
        }
        int l=0, r=0;
        HashMap<Character, Integer> hms=new HashMap<>();
        int al=-1, ar=-1;
        while(r<s.length()){
            hms.put(s.charAt(r), hms.getOrDefault(s.charAt(r),0)+1);
            if(hmt.containsKey(s.charAt(r)) && hms.get(s.charAt(r))<=hmt.get(s.charAt(r))){
                count++;
            }
            while(count==t.length()){
                // System.out.println("l:" +l+" r: "+r);
                if(res>=(r-l+1)){
                    res=(r-l+1);
                    al=l;
                    ar=r;
                }
                hms.put(s.charAt(l), hms.getOrDefault(s.charAt(l), 0)-1);
                if(hmt.containsKey(s.charAt(l)) && hms.get(s.charAt(l))<hmt.get(s.charAt(l))){
                    count--;
                }
                l++;
            }
            r++;
        }
        if(al==-1 || ar==-1){
            return "";
        }
        // System.out.println("al : "+al+" ar: " +ar);
        return s.substring(al, ar+1);
    }
}