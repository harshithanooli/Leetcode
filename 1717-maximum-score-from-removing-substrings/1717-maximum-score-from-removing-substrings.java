class Solution {
    public int getProfit(StringBuilder sb, char first, char second, int h, int l){
        int res=0;
        Stack<Character> st = new Stack<Character>();
        st.push(sb.charAt(0));

            
            for(int i=1;i<sb.length();i++){
                if(sb.charAt(i)==second && !st.isEmpty() && st.peek()==first){
                    st.pop();
                    res=res+h;
                }
                else{
                    st.push(sb.charAt(i));
                }
            }

            sb=new StringBuilder();

            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            sb=sb.reverse();
            st=new Stack<>();

            if(sb.length()>0) {
            st.push(sb.charAt(0));

            
            for(int i=1;i<sb.length();i++){
                if(sb.charAt(i)==first && !st.isEmpty() && st.peek()==second){
                    st.pop();
                    res=res+l;
                }
                else{
                    st.push(sb.charAt(i));
                }
            }
            }
            
        return res;
    }
    
    public int maximumGain(String s, int x, int y) {
        if(s.length()==1){
            return 0;
        }
        StringBuilder sb = new StringBuilder(s);
        int res; 
        if(x>y)
        res = getProfit(sb, 'a', 'b', x, y);
        else
        res = getProfit(sb, 'b', 'a', y,x);
        

        return res;
    }
}