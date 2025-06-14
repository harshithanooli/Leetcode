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
        HashMap<Character, Integer> sMap=new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int tLength = t.length(), sLength = s.length();
        for(int i=0;i<tLength;i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        System.out.println(tMap);
        int l=0;
        for(int i=0;i<sLength;i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);

            while(l<i && check(sMap, tMap)){
                if(res.equals("") || i-l+1< res.length()){
                    res=s.substring(l, i+1);
                }
                sMap.put(s.charAt(l), sMap.get(s.charAt(l))-1);
                if(sMap.get(s.charAt(l))==0)
                    sMap.remove(s.charAt(l));
                l++;
            }
            System.out.println("i : "+i+" l: "+l);
            System.out.println("Res: "+res);
            
        }

        return res;
    }
}