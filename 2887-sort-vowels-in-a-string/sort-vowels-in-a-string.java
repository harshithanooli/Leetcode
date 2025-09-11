class Solution {
    public String sortVowels(String s) {

        ArrayList<Character> vowels = new ArrayList<>();
        char[] vowel = {'a','e','i','o','u','A','E','I','O','U'};

        for(char ch:s.toCharArray()){
            for(char c:vowel){
                if(c==ch){
                    vowels.add(ch);
                }
            }    
        } 
        int j=0;
        Collections.sort(vowels);
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            boolean flag=false;
            for(char c:vowel){
                if(c==s.charAt(i)){
                    sb.append(vowels.get(j));
                    j++;
                    flag=true;
                    break;
                }  
            }
            if(!flag){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}