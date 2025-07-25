class Solution {

    public void genP(int open,int close, int n, String str, List<String> res){
        if(str.length()==2*n){
            res.add(str);
            return;
        }
        if(open<n){
            
            genP(open+1, close, n, str+'(', res);
        }
        if(close<open){
            
            genP(open, close+1, n, str+')', res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
       
        String str="";
        genP(0, 0, n, str, res);

        return res;
    }
}