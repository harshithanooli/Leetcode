class Solution {

    public boolean check(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap){
        for(Character ch:tMap.keySet()){
            if(!sMap.containsKey(ch) || sMap.get(ch)<tMap.get(ch))
                return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(s.equals(t))
        return s;
        else if (s.length()<t.length()){
            return "";
        }
        String res="";
        int minLength=Integer.MAX_VALUE, al=-1, ar=-1;
        HashMap<Character, Integer> sMap=new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int tLength = t.length(), sLength = s.length();
        for(int i=0;i<tLength;i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        int l=0,count=0;
        for(int i=0;i<sLength;i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
            if(tMap.containsKey(s.charAt(i)) && sMap.get(s.charAt(i))<=tMap.get(s.charAt(i)))
            count++;

            while(count==tLength){
                if(res.equals("") || i-l+1< res.length()){
                    res=s.substring(l, i+1);
                }
                sMap.put(s.charAt(l), sMap.get(s.charAt(l))-1);
                if(tMap.containsKey(s.charAt(l)) && sMap.get(s.charAt(l))<tMap.get(s.charAt(l))){
                    count--;
                }
                l++;
            }
            
            
        }

        return res;
    }
}