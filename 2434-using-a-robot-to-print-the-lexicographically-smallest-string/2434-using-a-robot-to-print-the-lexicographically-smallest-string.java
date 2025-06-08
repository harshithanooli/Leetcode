class Solution {
    public String robotWithString(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder res=new StringBuilder("");
        int n=s.length();
        char[] ch=new char[n];
        ch[n-1]=s.charAt(n-1);
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)<ch[i+1]){
                ch[i]=s.charAt(i);
            }
            else{
                ch[i]=ch[i+1];
            }
        }
        for(int i=0;i<s.length();i++){
            
                st.push(s.charAt(i));

                char minChar= (i==n-1)? s.charAt(i) : ch[i+1];

                while(!st.isEmpty() && minChar>=st.peek()){
                    res.append(st.pop());
                }
            
        }
        while(!st.isEmpty()){
            res.append(st.pop());
        }

        return res.toString();
    }
}