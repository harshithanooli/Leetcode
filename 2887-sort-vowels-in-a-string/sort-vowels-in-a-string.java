class Solution {
    public String sortVowels(String s) {

        ArrayList<Character> vowels = new ArrayList<>();
        Character[] chars = {'a','e','i','o','u','A','E','I','O','U'};
        HashSet<Character> vowel=new HashSet<Character>(Arrays.asList(chars));

        for(char ch:s.toCharArray()){
            
                if(vowel.contains(ch)){
                    vowels.add(ch);
                }
              
        } 
        int j=0;
        Collections.sort(vowels);
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            boolean flag=false;
            if (vowel.contains(s.charAt(i))){
                sb.append(vowels.get(j));
                j++;
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}